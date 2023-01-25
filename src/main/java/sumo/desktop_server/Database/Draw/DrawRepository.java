package sumo.desktop_server.Database.Draw;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrawRepository extends JpaRepository<Draw, Long> {
    Draw findDrawById(Long id);
    List<Draw> findAllBy();
    Draw findByCategoryAtCompetitionId(Long id);
}
