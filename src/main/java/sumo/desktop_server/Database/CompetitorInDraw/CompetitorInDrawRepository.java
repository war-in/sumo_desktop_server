package sumo.desktop_server.Database.CompetitorInDraw;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.Draw.Draw;

import java.util.List;

public interface CompetitorInDrawRepository extends JpaRepository<CompetitorInDraw, Long> {
    List<CompetitorInDraw> findAllByDraw(Draw draw);

}
