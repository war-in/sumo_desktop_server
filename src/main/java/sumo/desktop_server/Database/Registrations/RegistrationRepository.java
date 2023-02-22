package sumo.desktop_server.Database.Registrations;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitor;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Registration findRegistrationByCategoryAtCompetitionAndCompetitor(CategoryAtCompetition categoryAtCompetition, Competitor competitor);
    List<Registration> findRegistrationsByCategoryAtCompetition(CategoryAtCompetition categoryAtCompetition);
    List<Registration> findRegistrationsByCompetitor(Competitor competitor);
    long deleteByCategoryAtCompetitionAndCompetitor(CategoryAtCompetition categoryAtCompetition,Competitor competitor);
}
