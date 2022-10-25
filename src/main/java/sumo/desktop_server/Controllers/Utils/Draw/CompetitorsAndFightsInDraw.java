package sumo.desktop_server.Controllers.Utils.Draw;

import lombok.AllArgsConstructor;
import lombok.Data;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Fight.Fight;

import java.util.List;

@Data
@AllArgsConstructor
public class CompetitorsAndFightsInDraw {
    private List<Competitor> competitors;
    private List<Fight> fights;
}
