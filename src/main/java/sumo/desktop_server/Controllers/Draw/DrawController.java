package sumo.desktop_server.Controllers.Draw;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Controllers.Utils.Draw.CategoryAndCompetitors;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;
import sumo.desktop_server.Database.Competition.CompetitionService;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Draw.DrawService;
import sumo.desktop_server.Database.DrawType.DrawType;
import sumo.desktop_server.Database.DrawType.DrawTypeRepository;
import sumo.desktop_server.Database.DrawType.DrawTypeService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/draw")
@RequiredArgsConstructor
public class DrawController {

    private final CompetitionService competitionService;
    private final DrawTypeService drawTypeService;
    private final DrawService drawService;

    @GetMapping("/categories-with-competitors")
    public ResponseEntity<List<CategoryAndCompetitors>> getCategoriesWithCompetitors(@RequestParam Long competitionId) {
        List<CategoryAndCompetitors> categoriesAndCompetitors = competitionService.getCategoriesAndCompetitors(competitionId);

        return ResponseEntity.ok().body(categoriesAndCompetitors);
    }

    @GetMapping("/suggested-draw-types")
    public ResponseEntity<List<DrawType>> getSuggestedDrawTypes(@RequestParam Long numberOfCompetitors, @RequestParam String region) {
        List<DrawType> drawTypes = drawTypeService.getDrawTypesAboveSpecifiedNumberOfCompetitors(numberOfCompetitors, region);

        return ResponseEntity.ok().body(drawTypes);
    }

    @PostMapping("")
    public ResponseEntity<List<?>> prepareDraw(@RequestBody CompetitorsAndDrawType competitorsAndDrawType) {
        List<?> preparedCompetitors = drawService.prepareDraw(competitorsAndDrawType);

        return ResponseEntity.ok().body(preparedCompetitors);
    }
}
