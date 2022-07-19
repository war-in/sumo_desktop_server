package sumo.desktop_server.Database.CompetitionType;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.Competition.Competition;

public interface CompetitionTypeRepository extends JpaRepository<CompetitionType, Long> {
}
