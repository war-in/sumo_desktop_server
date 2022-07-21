package sumo.desktop_server.Controllers.Draw;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sumo.desktop_server.Controllers.Utils.Draw.CategoryAndCompetitors;
import sumo.desktop_server.Database.Competition.CompetitionService;

import java.util.List;

@RestController
@RequestMapping("/draw")
@RequiredArgsConstructor
public class DrawController {

    private final CompetitionService competitionService;

    @GetMapping("/get-categories-with-competitors")
    public ResponseEntity<List<CategoryAndCompetitors>> getCategoriesWithCompetitors(@RequestParam Long competitionId) {
        List<CategoryAndCompetitors> categoriesAndCompetitors = competitionService.getCategoriesAndCompetitors(competitionId);

        return ResponseEntity.ok().body(categoriesAndCompetitors);
    }
}
