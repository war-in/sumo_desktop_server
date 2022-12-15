package sumo.desktop_server.Controllers.Report;

import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndFightsInDraw;
import sumo.desktop_server.Controllers.Utils.Report.GroupReportAgeAndSexDivision;
import sumo.desktop_server.Controllers.Utils.Report.ResultsData;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;
import sumo.desktop_server.Database.AgeCategory.AgeCategoryRepository;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionPdfReport;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionService;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competition.CompetitionRepository;
import sumo.desktop_server.Database.Competition.CompetitionService;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDrawRepository;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Draw.DrawRepository;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Fight.FightService;
import sumo.desktop_server.Database.Results.Result;
import sumo.desktop_server.Database.Results.ResultService;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ResultService resultService;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final DrawRepository drawRepository;
    private final CompetitorInDrawRepository competitorInDrawRepository;
    private final FightService fightService;
    private final CompetitionRepository competitionRepository;
    private final AgeCategoryRepository ageCategoryRepository;

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
        List<Competitor> competitors = resultService.getCompetitorsByCategoryAtCompetitionId(categoryAtCompetitionId);
        List<Result> results = resultService.getResultsByCategoryAtCompetitionId(categoryAtCompetitionId);


        CategoryAtCompetition categoryAtCompetition = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        List<Draw> draws = drawRepository.findByCategoryAtCompetitionId(categoryAtCompetitionId);

        //bedzie jeden draw
        //TODO one draw
        Draw draw = draws.get(0);
        List<Fight> competitorsAndFightsInDraw = fightService.getFightsByDrawId(draw.getId());

        List<CompetitorInDraw> competitorInDrawList = competitorInDrawRepository.findAllByDraw(draw);



        CategoryAtCompetitionPdfReport generator = new CategoryAtCompetitionPdfReport();
        ByteArrayInputStream bis = generator.categoryAtCompetitionReport(results,competitors,categoryAtCompetition,draw,competitorInDrawList,competitorsAndFightsInDraw);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=individual_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .cacheControl(CacheControl.noCache())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }
    @GetMapping("/pdf-report-full")
    public ResponseEntity<InputStreamResource> fullReport(@RequestParam(name = "competition-id") Long competitionId,@RequestParam(name = "age-category-id") Long ageCategoryId,@RequestParam(name = "sex") String sex) throws DocumentException, FileNotFoundException {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        List<CategoryAtCompetition> categoryAtCompetitions = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);
        List<Result> results = resultService.getResultsByCategoryAtCompetitionId(categoryAtCompetitions.get(0).getId());
        AgeCategory ageCategory = ageCategoryRepository.findAgeCategoryById(ageCategoryId);
        GroupReportAgeAndSexDivision groupReportAgeAndSexDivision = new GroupReportAgeAndSexDivision();

        groupReportAgeAndSexDivision.generateReport(competition,sex,ageCategory,categoryAtCompetitions,results);


        return null;
    }
}
