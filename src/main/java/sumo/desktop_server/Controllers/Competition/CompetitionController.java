package sumo.desktop_server.Controllers.Competition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competition.CompetitionService;

import java.util.List;

@RestController
@RequestMapping("/competition")
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @GetMapping
    ResponseEntity<List<Competition>> getAllCompetiotion() {
        return ResponseEntity.ok().body(competitionService.getAllCompetitions());
    }
}
