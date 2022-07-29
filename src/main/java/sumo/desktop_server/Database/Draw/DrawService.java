package sumo.desktop_server.Database.Draw;

import org.springframework.web.bind.annotation.RequestBody;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;

import java.util.List;

public interface DrawService {
    List<?> prepareDraw(@RequestBody CompetitorsAndDrawType competitorsAndDrawType);
}
