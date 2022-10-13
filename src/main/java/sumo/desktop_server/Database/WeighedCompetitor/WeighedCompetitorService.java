package sumo.desktop_server.Database.WeighedCompetitor;


public interface WeighedCompetitorService {
    WeighedCompetitor getCompetitorsWeighingDetailsAtSpecifiedCategory(Long categoryAtCompetitionId, Long competitorId);
    WeighedCompetitor setWeighingDetails(Long categoryAtCompetitionId, Long competitorId, Float weight);
}
