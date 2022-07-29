package sumo.desktop_server.Controllers.Utils.Draw;

import lombok.Data;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.DrawType.DrawType;

import java.util.List;

@Data
public class CompetitorsAndDrawType {
    private List<Competitor> competitors;
    private DrawType drawType;
}
