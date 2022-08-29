package sumo.desktop_server.Database.Draw;

import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;
import sumo.desktop_server.Controllers.Utils.Draw.DataToSaveDraw;
import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;

public interface DrawService {
    List<Competitor> prepareDraw(CompetitorsAndDrawType competitorsAndDrawType);
    Draw saveDraw(DataToSaveDraw dataToSaveDraw);
    List<Competitor> getCompetitorsInDraw(Long drawId);
}
