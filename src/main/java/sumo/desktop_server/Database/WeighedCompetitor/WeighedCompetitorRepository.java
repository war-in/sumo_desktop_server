package sumo.desktop_server.Database.WeighedCompetitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sumo.desktop_server.Database.Registrations.Registration;

@Repository
public interface WeighedCompetitorRepository extends JpaRepository<WeighedCompetitor, Long> {
    WeighedCompetitor findWeighedCompetitorByRegistrationId(Long registrationId);
    WeighedCompetitor findWeighedCompetitorById(Long id);
    void deleteWeighedCompetitorByRegistration(Registration registration);
}
