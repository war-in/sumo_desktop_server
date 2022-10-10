package sumo.desktop_server.Database.Fight;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.Draw.Draw;

import java.util.List;

public interface FightRepository extends JpaRepository<Fight,Long> {
    List<Fight> findFightsByDraw(Draw draw);
    Fight findFightByDrawAndNumberOfPlaceInDraw(Draw draw, int numberOfPlaceInDraw);
}
