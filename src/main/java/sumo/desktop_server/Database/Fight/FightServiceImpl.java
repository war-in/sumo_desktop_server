package sumo.desktop_server.Database.Fight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FightServiceImpl implements FightService {
    final FightRepository fightRepository;
    @Override
    public Fight saveFight(Fight fightToSave) {
        return fightRepository.save(fightToSave);
    }

    @Override
    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }
}
