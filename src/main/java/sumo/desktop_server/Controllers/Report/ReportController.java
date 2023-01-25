package sumo.desktop_server.Controllers.Report;

import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Controllers.Utils.Report.Compare.AgeComparator;
import sumo.desktop_server.Controllers.Utils.Report.Compare.GenderComparator;
import sumo.desktop_server.Controllers.Utils.Report.Compare.WeightCategorySorter;
import sumo.desktop_server.Controllers.Utils.Report.GroupReport;
import sumo.desktop_server.Controllers.Utils.Report.ResultsData;
import sumo.desktop_server.Controllers.Utils.Report.Utils.IndividualReportData;
import sumo.desktop_server.Controllers.Utils.Report.Utils.ReportService;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;
import sumo.desktop_server.Database.AgeCategory.AgeCategoryRepository;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionPdfReport;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competition.CompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.PointsClassification.PointsClassification;
import sumo.desktop_server.Database.PointsClassification.PointsClassificationRepository;
import sumo.desktop_server.Database.Results.Result;
import sumo.desktop_server.Database.Results.ResultService;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ResultService resultService;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final CompetitionRepository competitionRepository;
    private final AgeCategoryRepository ageCategoryRepository;
    private final PointsClassificationRepository pointsClassificationRepository;
    private final ReportService reportService;

    @PostMapping("/save")
    public ResponseEntity<?> saveResults(@RequestBody ResultsData resultsData) {
        resultService.saveResults(resultsData.getCategoryAtCompetitionId(), resultsData.getCompetitorsInOrder());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Competitor>> getCompetitorsSortedByPlacement(@RequestParam Long categoryAtCompetitionId) {
        List<Competitor> competitors = resultService.getCompetitorsByCategoryAtCompetitionId(categoryAtCompetitionId);
        return ResponseEntity.ok().body(competitors);
    }

    @GetMapping("/pdf-report")
    public ResponseEntity<InputStreamResource> categoryAtCompetitionReport(@RequestParam(name = "category-at-competition-id") Long categoryAtCompetitionId) {

        IndividualReportData reportData = reportService.getDataForIndividualReport(categoryAtCompetitionId);


        CategoryAtCompetitionPdfReport generator = new CategoryAtCompetitionPdfReport();
        ByteArrayInputStream bis = generator.categoryAtCompetitionReport
                (reportData.results(), reportData.competitors(), reportData.categoryAtCompetition(),
                        reportData.draw(), reportData.competitorInDrawList(), reportData.competitorsAndFightsInDraw());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=individual_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .cacheControl(CacheControl.noCache())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

    @GetMapping("/pdf-group-report-age-sex-division")
    public ResponseEntity<InputStreamResource> fullReport(@RequestParam(name = "competition-id") Long competitionId, @RequestParam(name = "age-category-id") Long ageCategoryId, @RequestParam(name = "sex") String sex) throws DocumentException, FileNotFoundException {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        AgeCategory ageCategory = ageCategoryRepository.findAgeCategoryById(ageCategoryId);


        List<CategoryAtCompetition> categoryAtCompetitions = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);

        List<CategoryAtCompetition> filteredCategoriesByAgeCategoryAndSex = categoryAtCompetitions.stream().filter(categoryAtCompetition ->
                categoryAtCompetition.getCategory().getAgeCategory().getId() == ageCategory.getId()
                        && categoryAtCompetition.getCategory().getSex().getSex().equals(sex)).sorted(new WeightCategorySorter()).toList();


        Map<Long,List<Result>> categoryIdToResult = new HashMap<>();
        for (CategoryAtCompetition categoryAtCompetition : filteredCategoriesByAgeCategoryAndSex) {
            categoryIdToResult.put(categoryAtCompetition.getId(), resultService.getResultsByCategoryAtCompetitionId(categoryAtCompetition.getId()));
        }

        GroupReport groupReport = new GroupReport();

        List<PointsClassification> pointsClassifications = pointsClassificationRepository.findPointsClassificationsByCompetitionIdAndAgeCategoryId(competition.getId(), ageCategory.getId());

        ByteArrayInputStream bis = groupReport.generateReport(reportService, competition, sex, ageCategory, filteredCategoriesByAgeCategoryAndSex, categoryIdToResult, pointsClassifications);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=individual_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .cacheControl(CacheControl.noCache())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

    @GetMapping("/pdf-group-report-age-division")
    public ResponseEntity<InputStreamResource> fullReport(@RequestParam(name = "competition-id") Long competitionId, @RequestParam(name = "age-category-id") Long ageCategoryId) throws DocumentException, FileNotFoundException {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        AgeCategory ageCategory = ageCategoryRepository.findAgeCategoryById(ageCategoryId);
        List<CategoryAtCompetition> categoryAtCompetitions = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);

        List<CategoryAtCompetition> filteredCategoriesByAgeCategory = categoryAtCompetitions.stream().filter(categoryAtCompetition ->
                categoryAtCompetition.getCategory().getAgeCategory().getId() == ageCategory.getId()
        ).sorted(new GenderComparator()
                .thenComparing(new WeightCategorySorter())).toList();

        Map<Long,List<Result>> categoryIdToResult = new HashMap<>();
        for (CategoryAtCompetition categoryAtCompetition : filteredCategoriesByAgeCategory) {
            categoryIdToResult.put(categoryAtCompetition.getId(), resultService.getResultsByCategoryAtCompetitionId(categoryAtCompetition.getId()));
        }

        GroupReport groupReport = new GroupReport();

        List<PointsClassification> pointsClassifications = pointsClassificationRepository.findPointsClassificationsByCompetitionIdAndAgeCategoryId(competition.getId(), ageCategory.getId());

        ByteArrayInputStream bis = groupReport.generateReport(reportService, competition, ageCategory, filteredCategoriesByAgeCategory, categoryIdToResult, pointsClassifications);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=individual_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .cacheControl(CacheControl.noCache())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

    @GetMapping("/pdf-group-report-sex-division")
    public ResponseEntity<InputStreamResource> fullReport(@RequestParam(name = "competition-id") Long competitionId, @RequestParam(name = "sex") String sex) throws DocumentException, FileNotFoundException {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        List<CategoryAtCompetition> categoryAtCompetitions = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);

        List<CategoryAtCompetition> filteredCategoriesBySex = categoryAtCompetitions.stream().filter(categoryAtCompetition ->
                categoryAtCompetition.getCategory().getSex().getSex().equals(sex)).sorted(new AgeComparator()
                .thenComparing(new WeightCategorySorter())).toList();


        Map<Long,List<Result>> categoryIdToResult = new HashMap<>();
        for (CategoryAtCompetition categoryAtCompetition : filteredCategoriesBySex) {
            categoryIdToResult.put(categoryAtCompetition.getId(), resultService.getResultsByCategoryAtCompetitionId(categoryAtCompetition.getId()));
        }

        GroupReport groupReport = new GroupReport();

        List<PointsClassification> pointsClassifications = pointsClassificationRepository.findPointsClassificationsByCompetitionId(competition.getId());

        ByteArrayInputStream bis = groupReport.generateReport(reportService, competition, sex, categoryAtCompetitions, categoryIdToResult, pointsClassifications);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=individual_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .cacheControl(CacheControl.noCache())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

    @GetMapping("/pdf-group-full")
    public ResponseEntity<InputStreamResource> fullReport(@RequestParam(name = "competition-id") Long competitionId) throws DocumentException, FileNotFoundException {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        List<CategoryAtCompetition> categoryAtCompetitions = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);

        Collections.sort(categoryAtCompetitions,new AgeComparator()
                .thenComparing(new GenderComparator()
                        .thenComparing(new WeightCategorySorter())));


        Map<Long,List<Result>> categoryIdToResult = new HashMap<>();
        for (CategoryAtCompetition categoryAtCompetition : categoryAtCompetitions) {
            categoryIdToResult.put(categoryAtCompetition.getId(), resultService.getResultsByCategoryAtCompetitionId(categoryAtCompetition.getId()));
        }

        GroupReport groupReport = new GroupReport();

        List<PointsClassification> pointsClassifications = pointsClassificationRepository.findPointsClassificationsByCompetitionId(competition.getId());

        ByteArrayInputStream bis = groupReport.generateReport(reportService, competition, categoryAtCompetitions, categoryIdToResult, pointsClassifications);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=individual_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .cacheControl(CacheControl.noCache())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }
}
