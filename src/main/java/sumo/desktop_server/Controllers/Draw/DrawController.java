package sumo.desktop_server.Controllers.Draw;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Controllers.Utils.Draw.CategoryAndCompetitors;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndFightsInDraw;
import sumo.desktop_server.Controllers.Utils.Draw.DataToSaveDraw;
import sumo.desktop_server.Database.Competition.CompetitionService;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Draw.DrawService;
import sumo.desktop_server.Database.DrawType.DrawType;
import sumo.desktop_server.Database.DrawType.DrawTypeService;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Fight.FightService;

import java.util.*;

@RestController
@RequestMapping("/draw")
@RequiredArgsConstructor
public class DrawController {

    private final CompetitionService competitionService;
    private final DrawTypeService drawTypeService;
    private final DrawService drawService;
    private final FightService fightService;

    @GetMapping("/categories-with-competitors")
    public ResponseEntity<List<CategoryAndCompetitors>> getCategoriesWithCompetitors(@RequestParam Long competitionId) {
        List<CategoryAndCompetitors> categoriesAndCompetitors = competitionService.getCategoriesAndCompetitors(competitionId);

        return ResponseEntity.ok().body(categoriesAndCompetitors);
    }

    @GetMapping("/categories-with-competitors-with-weight-validation")
    public ResponseEntity<List<CategoryAndCompetitors>> getCategoriesWithCompetitorsWithWeightValidation(@RequestParam Long competitionId) {
        List<CategoryAndCompetitors> categoriesAndCompetitors = competitionService.getCategoriesAndCompetitors(competitionId);

        return ResponseEntity.ok().body(categoriesAndCompetitors);
    }

    @GetMapping("/suggested-draw-types")
    public ResponseEntity<List<DrawType>> getSuggestedDrawTypes(@RequestParam Long numberOfCompetitors, @RequestParam String region) {
        List<DrawType> drawTypes = drawTypeService.getDrawTypesAboveSpecifiedNumberOfCompetitors(numberOfCompetitors, region);

        return ResponseEntity.ok().body(drawTypes);
    }

    @PostMapping
    public ResponseEntity<List<Competitor>> prepareDraw(@RequestBody CompetitorsAndDrawType competitorsAndDrawType) {
        List<Competitor> preparedCompetitors = drawService.prepareDraw(competitorsAndDrawType);

        return ResponseEntity.ok().body(preparedCompetitors);
    }

    @PostMapping("/save-draw")
    public ResponseEntity<Draw> saveDraw(@RequestBody DataToSaveDraw dataToSaveDraw) {
        Draw draw = drawService.saveDraw(dataToSaveDraw);

        return ResponseEntity.ok().body(draw);
    }

    @GetMapping("/ready-draw")
    public ResponseEntity<List<Competitor>> getReadyDraw(@RequestParam Long drawId) {
        List<Competitor> competitors = drawService.getCompetitorsInDraw(drawId);
        return ResponseEntity.ok().body(competitors);
    }

    @GetMapping("/with-fights")
    public ResponseEntity<CompetitorsAndFightsInDraw> getDrawWithGeneratedFights(@RequestParam Long drawId) {
        List<Competitor> competitors = drawService.getCompetitorsInDraw(drawId);
        List<Fight> fights = fightService.getFightsByDrawId(drawId);

        return ResponseEntity.ok().body(new CompetitorsAndFightsInDraw(competitors, fights));
    }
}
