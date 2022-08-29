package sumo.desktop_server.Database.Draw;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DrawRepository extends JpaRepository<Draw, Long> {
    Draw findDrawById(Long id);
}
