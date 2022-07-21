package sumo.desktop_server.Database.WeighedCompetitor;


public interface WeighedCompetitorService {
    WeighedCompetitor getCompetitorsWeighingDetailsAtSpecifiedCategory(Long categoryAtCompetitionId, Long competitorId);
    WeighedCompetitor setWeighingDetails(WeighedCompetitor weighedCompetitor);
}
