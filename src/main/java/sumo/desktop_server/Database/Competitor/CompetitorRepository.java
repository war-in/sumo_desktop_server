package sumo.desktop_server.Database.Competitor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitorRepository extends JpaRepository<Competitor, Long> {
    Competitor findCompetitorById(Long id);
}
