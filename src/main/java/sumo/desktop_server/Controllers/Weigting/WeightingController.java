package sumo.desktop_server.Controllers.Weigting;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competition.CompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;
import sumo.desktop_server.Database.Registrations.Registration;
import sumo.desktop_server.Database.Registrations.RegistrationRepository;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitor;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/weighting")
@RequiredArgsConstructor
public class WeightingController {

    private final RegistrationRepository registrationRepository;
    private final WeighedCompetitorRepository weighedCompetitorRepository;
    private final CompetitionRepository competitionRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final CompetitorRepository competitorRepository;

    @GetMapping("/get-weighting-details")
    public ResponseEntity<WeighedCompetitor> getWeighingDetails(@RequestParam Long categoryAtCompetitionId, @RequestParam Long competitorId) {
        CategoryAtCompetition category = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);

        Registration registration = registrationRepository.findRegistrationByCategoryAtCompetitionAndCompetitor(category, competitor);
        WeighedCompetitor weighedCompetitor = weighedCompetitorRepository.findWeighedCompetitorByRegistrationId(registration.getId());

        return ResponseEntity.ok().body(weighedCompetitor);
    }

    @PostMapping("/update-weighting-details")
    public ResponseEntity<WeighedCompetitor> updateWeightingDetails(@RequestParam WeighedCompetitor weighedCompetitor) {
        LocalDate date = LocalDate.now();
        weighedCompetitor.setDate(date);

        weighedCompetitor = weighedCompetitorRepository.save(weighedCompetitor);

        return ResponseEntity.ok().body(weighedCompetitor);
    }

    @GetMapping("/get-competitors")
    public ResponseEntity<List<Competitor>> getCompetitors(@RequestParam Long competitionId) {
        Competition competition = competitionRepository.findCompetitionById(competitionId);

        List<CategoryAtCompetition> categories = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);

        HashSet<Competitor> competitors = new HashSet<>();

        for(CategoryAtCompetition category: categories) {
            List<Registration> registrations = registrationRepository.findRegistrationsByCategoryAtCompetition(category);

            registrations.forEach(registration -> {
                competitors.add(registration.getCompetitor());
            });
        }
        return ResponseEntity.ok().body(competitors.stream().toList());
    }

    @GetMapping("/get-categories")
    public ResponseEntity<List<CategoryAtCompetition>> getCategoriesByCompetitor(@RequestParam Long competitorId, @RequestParam Long competitionId) {
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);
        Competition competition = competitionRepository.findCompetitionById(competitionId);

        List<Registration> registrations = registrationRepository.findRegistrationsByCompetitor(competitor);
        registrations = registrations.stream().filter(registration -> registration.getCategoryAtCompetition().getCompetition().equals(competition)).toList();

        List<CategoryAtCompetition> categories = new ArrayList<>();
        for(Registration registration: registrations) {
            categories.add(registration.getCategoryAtCompetition());
        }

        return ResponseEntity.ok().body(categories);
    }
}
