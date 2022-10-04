package sumo.desktop_server.Database.Draw;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.DrawType.DrawType;

public interface DrawRepository extends JpaRepository<Draw, Long> {
    Draw findDrawById(Long id);
}
