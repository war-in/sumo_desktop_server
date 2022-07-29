package sumo.desktop_server.Database.Draw;

import org.springframework.web.bind.annotation.RequestBody;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;
import sumo.desktop_server.Controllers.Utils.Draw.DataToSaveDraw;
import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;

public interface DrawService {
    List<?> prepareDraw(CompetitorsAndDrawType competitorsAndDrawType);
    Draw saveDraw(DataToSaveDraw dataToSaveDraw);
}
