package sumo.desktop_server.Database.Draw;

import net.minidev.json.JSONObject;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;
import sumo.desktop_server.Controllers.Utils.Draw.DataToSaveDraw;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;

public interface DrawService {
    List<Competitor> prepareDraw(CompetitorsAndDrawType competitorsAndDrawType);
    Draw saveDraw(DataToSaveDraw dataToSaveDraw);
    List<Competitor> getCompetitorsInDraw(Long drawId);

    JSONObject getDrawsDetailsByCompetition(Competition competition);
    JSONObject getEndedDrawsByCompetition(Competition competition);
}
