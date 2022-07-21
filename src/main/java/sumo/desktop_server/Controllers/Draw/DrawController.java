package sumo.desktop_server.Controllers.Draw;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sumo.desktop_server.Controllers.Utils.Draw.CategoryAndCompetitors;
import sumo.desktop_server.Database.Competition.CompetitionService;
import sumo.desktop_server.Database.DrawType.DrawType;
import sumo.desktop_server.Database.DrawType.DrawTypeService;
import sumo.desktop_server.Database.Region.Region;

import java.util.List;

@RestController
@RequestMapping("/draw")
@RequiredArgsConstructor
public class DrawController {

    private final CompetitionService competitionService;
    private final DrawTypeService drawTypeService;

    @GetMapping("/get-categories-with-competitors")
    public ResponseEntity<List<CategoryAndCompetitors>> getCategoriesWithCompetitors(@RequestParam Long competitionId) {
        List<CategoryAndCompetitors> categoriesAndCompetitors = competitionService.getCategoriesAndCompetitors(competitionId);

        return ResponseEntity.ok().body(categoriesAndCompetitors);
    }

    @GetMapping("/get-suggested-draw-types")
    public ResponseEntity<List<DrawType>> getSuggestedDrawTypes(@RequestParam Long numberOfCompetitors, @RequestParam String region) {
        List<DrawType> drawTypes = drawTypeService.getDrawTypesAboveSpecifiedNumberOfCompetitors(numberOfCompetitors, region);

        return ResponseEntity.ok().body(drawTypes);
    }

}
