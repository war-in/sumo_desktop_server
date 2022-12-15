package sumo.desktop_server.Database.Results;

import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;

public interface ResultService {
    void saveResults(Long categoryAtCompetitionId, List<Competitor> competitorsInOrder);
    List<Competitor> getCompetitorsByCategoryAtCompetitionId(Long categoryAtCompetitionId);
    List<Result> getResultsByCategoryAtCompetitionId(Long categoryAtCompetitionId);
}
