package sumo.desktop_server.Database.Competitor;

import sumo.desktop_server.Database.Category.Category;

import java.util.List;

public interface CompetitorService {
    List<Category> getCompetitorCategoriesAtSpecifiedCompetition(Long competitorId, Long competitionId);
}
