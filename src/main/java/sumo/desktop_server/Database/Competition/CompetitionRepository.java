package sumo.desktop_server.Database.Competition;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitor;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    Competition findCompetitionById(Long id);
}
