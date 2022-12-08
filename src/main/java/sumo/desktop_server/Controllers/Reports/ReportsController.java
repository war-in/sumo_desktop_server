package sumo.desktop_server.Controllers.Reports;

import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competition.CompetitionRepository;
import sumo.desktop_server.Database.Draw.DrawService;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {
    private final CompetitionRepository competitionRepository;
    private final DrawService drawService;

    @GetMapping("/individual")
    public ResponseEntity<JSONObject> getMenuData(@RequestParam Long competitionId) {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        return ResponseEntity.ok().body(drawService.getEndedDrawsByCompetition(competition));
    }
}
