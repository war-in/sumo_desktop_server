package sumo.desktop_server.Controllers.Utils.Weighting;

import lombok.Data;

@Data
public class WeightingDetails {
    private Long categoryAtCompetitionId;
    private Long competitorId;
    private Float weight;
}
