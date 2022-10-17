package sumo.desktop_server.Controllers.Utils.Report;

import lombok.Data;
import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;

@Data
public class ResultsData {
    private Long categoryAtCompetitionId;
    private List<Competitor> competitorsInOrder;
}
