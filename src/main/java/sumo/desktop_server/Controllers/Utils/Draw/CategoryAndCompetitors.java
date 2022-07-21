package sumo.desktop_server.Controllers.Utils.Draw;

import lombok.Data;
import sumo.desktop_server.Database.Category.Category;
import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;


@Data
public class CategoryAndCompetitors {
    private Category category;
    private List<Competitor> competitors;
}
