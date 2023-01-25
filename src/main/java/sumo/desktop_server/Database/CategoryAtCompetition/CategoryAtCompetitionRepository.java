package sumo.desktop_server.Database.CategoryAtCompetition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitor;

import java.util.List;

@Repository
public interface CategoryAtCompetitionRepository extends JpaRepository<CategoryAtCompetition, Long> {
    List<CategoryAtCompetition> findCategoryAtCompetitionsByCompetition(Competition competition);
    CategoryAtCompetition findCategoryAtCompetitionById(Long id);
    //List<CategoryAtCompetition> findCategoryAtCompetitionByCompetitionIdAndCategory(Long competitionId,Long categoryId);
}
