package sumo.desktop_server.Database.WeighedCompetitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeighedCompetitorRepository extends JpaRepository<WeighedCompetitor, Long> {
    WeighedCompetitor findWeighedCompetitorByRegistrationId(Long registrationId);
}
