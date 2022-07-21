package sumo.desktop_server.Database.Competition;

import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;

public interface CompetitionService {
    List<Competitor> getAllCompetitors(Long competitionId);
}
