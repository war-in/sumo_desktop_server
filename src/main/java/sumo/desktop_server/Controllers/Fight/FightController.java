package sumo.desktop_server.Controllers.Fight;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Fight.FightService;

import java.util.List;

@RestController
@RequestMapping("/fights")
@RequiredArgsConstructor
public class FightController {
    final FightService fightService;

    @PostMapping("/save")
    public ResponseEntity<Fight> saveFight(@RequestBody Fight fightToSave) {
        Fight fight = fightService.saveFight(fightToSave);
        return ResponseEntity.ok().body(fight);
    }
    @GetMapping()
    public ResponseEntity<List<Fight>> getFights() {
        return ResponseEntity.ok().body(fightService.getAllFights());
    }
}
