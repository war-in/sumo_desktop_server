package sumo.desktop_server.Database.Competition;

import sumo.desktop_server.Controllers.Utils.Draw.CategoryAndCompetitors;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.Competitor.Competitor;

import java.util.List;

public interface CompetitionService {
    List<Competitor> getAllCompetitors(Long competitionId);
    List<CategoryAndCompetitors> getCategoriesAndCompetitors(Long competitionId);
    List<Competition> getAllCompetitions();
    List<CategoryAtCompetition> getCategoriesAtCompetition(Long competitionId);
}
