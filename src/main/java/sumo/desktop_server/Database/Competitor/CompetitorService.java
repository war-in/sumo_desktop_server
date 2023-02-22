package sumo.desktop_server.Database.Competitor;

import sumo.desktop_server.Database.Category.Category;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;

import java.util.List;

public interface CompetitorService {
    List<Category> getCompetitorCategoriesAtSpecifiedCompetition(Long competitorId, Long competitionId);

    List<CategoryAtCompetition> getCompetitorCategoriesAtCompetitionAtSpecifiedCompetition(Long competitorId, Long competitionId);

    Competitor getCompetitorById(Long id);
}
