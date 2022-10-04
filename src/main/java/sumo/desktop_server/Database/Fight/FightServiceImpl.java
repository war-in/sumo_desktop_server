package sumo.desktop_server.Database.Fight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Draw.DrawRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FightServiceImpl implements FightService {
    private final FightRepository fightRepository;
    private final DrawRepository drawRepository;

    @Override
    public Fight saveFight(Fight fightToSave) {
        return fightRepository.save(fightToSave);
    }

    @Override
    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }

    @Override
    public List<Fight> getFightsByDrawId(Long drawId) {
        Draw draw = drawRepository.findDrawById(drawId);
        return fightRepository.findFightsByDraw(draw);
    }
}
