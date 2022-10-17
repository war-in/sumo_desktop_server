package sumo.desktop_server.Database.Results;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Long> {
    List<Result> findResultsByCategoryAtCompetition(CategoryAtCompetition categoryAtCompetition);
}
