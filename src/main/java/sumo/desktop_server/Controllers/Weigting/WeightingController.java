package sumo.desktop_server.Controllers.Weigting;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Database.Category.Category;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competition.CompetitionRepository;
import sumo.desktop_server.Database.Competition.CompetitionService;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;
import sumo.desktop_server.Database.Competitor.CompetitorService;
import sumo.desktop_server.Database.Registrations.RegistrationRepository;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitor;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitorRepository;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitorService;

import java.util.List;

@RestController
@RequestMapping("/weighting")
@RequiredArgsConstructor
public class WeightingController {

    private final WeighedCompetitorService weighedCompetitorService;
    private final CompetitionService competitionService;
    private final CompetitorService competitorService;

    @GetMapping("/get-weighing-details")
    public ResponseEntity<WeighedCompetitor> getWeighingDetails(@RequestParam Long categoryAtCompetitionId, @RequestParam Long competitorId) {
        WeighedCompetitor weighedCompetitor = weighedCompetitorService.getCompetitorsWeighingDetailsAtSpecifiedCategory(categoryAtCompetitionId, competitorId);

        return ResponseEntity.ok().body(weighedCompetitor);
    }

    @PostMapping("/update-weighing-details")
    public ResponseEntity<WeighedCompetitor> updateWeighingDetails(@RequestBody WeighedCompetitor weighedCompetitor) {
        return ResponseEntity.ok().body(weighedCompetitorService.setWeighingDetails(weighedCompetitor));
    }

    @GetMapping("/get-competitors")
    public ResponseEntity<List<Competitor>> getCompetitors(@RequestParam Long competitionId) {
        List<Competitor> competitors = competitionService.getAllCompetitors(competitionId);

        return ResponseEntity.ok().body(competitors);
    }

    @GetMapping("/get-categories")
    public ResponseEntity<List<Category>> getCategoriesByCompetitor(@RequestParam Long competitorId, @RequestParam Long competitionId) {
        List<Category> categories = competitorService.getCompetitorCategoriesAtSpecifiedCompetition(competitorId, competitionId);

        return ResponseEntity.ok().body(categories);
    }
}
