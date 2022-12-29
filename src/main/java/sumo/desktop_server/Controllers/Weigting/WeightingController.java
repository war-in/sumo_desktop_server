package sumo.desktop_server.Controllers.Weigting;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sumo.desktop_server.Controllers.Utils.Weighting.WeightingDetails;
import sumo.desktop_server.Database.Category.Category;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.Competition.CompetitionService;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorService;
import sumo.desktop_server.Database.Registrations.Registration;
import sumo.desktop_server.Database.Registrations.RegistrationService;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitor;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitorService;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/weighting")
@RequiredArgsConstructor
public class WeightingController {

    private final WeighedCompetitorService weighedCompetitorService;
    private final CompetitionService competitionService;
    private final CompetitorService competitorService;

    private final RegistrationService registrationService;

    @GetMapping("/weighting-details")
    public ResponseEntity<WeighedCompetitor> getWeighingDetails(@RequestParam Long categoryAtCompetitionId, @RequestParam Long competitorId) {
        WeighedCompetitor weighedCompetitor = weighedCompetitorService.getCompetitorsWeighingDetailsAtSpecifiedCategory(categoryAtCompetitionId, competitorId);

        return ResponseEntity.ok().body(weighedCompetitor);
    }

    @PostMapping("/update-weighting-details")
    public ResponseEntity<WeighedCompetitor> updateWeighingDetails(@RequestBody WeightingDetails weightingDetails) {
        return ResponseEntity.ok().body(
            weighedCompetitorService.setWeighingDetails(
                weightingDetails.getCategoryAtCompetitionId(),
                weightingDetails.getCompetitorId(),
                weightingDetails.getWeight()
            )
        );
    }

    @GetMapping("/competitors")
    public ResponseEntity<List<Competitor>> getCompetitors(@RequestParam Long competitionId) {
        List<Competitor> competitors = competitionService.getAllCompetitors(competitionId);

        return ResponseEntity.ok().body(competitors);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategoriesByCompetitor(@RequestParam Long competitorId, @RequestParam Long competitionId) {
        List<Category> categories = competitorService.getCompetitorCategoriesAtSpecifiedCompetition(competitorId, competitionId);

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/weightList")
    public ResponseEntity<List<String>> getWeightList(@RequestParam Long competitionId) {
        List<Competitor> competitors = competitionService.getAllCompetitors(competitionId);
        List<String> results = new LinkedList<>();
        competitors.forEach(competitor -> {
            List<Category> categories = competitorService.getCompetitorCategoriesAtSpecifiedCompetition(competitor.getId(), competitionId);
            categories.forEach(category -> {
                String record = competitor.getPersonalDetails().getName() + ";"
                    + competitor.getPersonalDetails().getSurname() + ";"
                    + competitor.getCountry() + ";"
                    + competitor.getPersonalDetails().getBirthDate().toString() + ";"
                    + category.getAgeCategory().getName()
                    + ";" + category.getWeightCategory();
                results.add(record);
            });
        });
        return ResponseEntity.ok().body(results);
    }

    @PostMapping("/addRegistration")
    public ResponseEntity<Registration> addCategoryToCompetitor(@RequestParam Long competitorId, @RequestParam Long categoryAtCompetitionId) {
        Registration result = registrationService.addRegistrationToCompetitor(categoryAtCompetitionId, competitorId);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/removeRegistration")
    public ResponseEntity<Long> removeCategoryToCompetitor(@RequestParam Long competitorId, @RequestParam Long categoryAtCompetitionId) {
        registrationService.removeRegistrationFromCompetitor(categoryAtCompetitionId, competitorId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAvailableCategoriesForCompetitor")
    public ResponseEntity<List<CategoryAtCompetition>> getCategoriesForCompetitor(@RequestParam Long competitorId, @RequestParam Long competitionId){
        Competitor competitor = competitorService.getCompetitorById(competitorId);
        List<CategoryAtCompetition> categoryAtCompetitions = competitorService.getCompetitorCategoriesAtCompetitionAtSpecifiedCompetition(competitorId,competitionId);
        List<CategoryAtCompetition> result  = competitionService.getCategoriesAtCompetition(competitionId).stream().filter(categories -> {
            return categories.getCategory().getSex().equals(competitor.getPersonalDetails().getSex());
        }).toList();
        result = result.stream().filter(categoryAtCompetition -> ! categoryAtCompetitions.contains(categoryAtCompetition)).toList();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getCategoryOfCompetitionOfCompetitor")
    public ResponseEntity<List<CategoryAtCompetition>> getRegistrationOfCompetitor(@RequestParam Long competitorId, @RequestParam Long competitionId){
        List<CategoryAtCompetition> result = competitorService.getCompetitorCategoriesAtCompetitionAtSpecifiedCompetition(competitorId, competitionId);
        return ResponseEntity.ok().body(result);
    }

}
