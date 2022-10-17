package sumo.desktop_server.Controllers.Report;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Controllers.Utils.Report.ResultsData;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Results.ResultService;

import java.util.List;


@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ResultService resultService;

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
}
