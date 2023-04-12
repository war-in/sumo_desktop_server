package sumo.desktop_server.Database.Fight;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionPdfReport;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Draw.DrawRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FightServiceImpl implements FightService {
    private final FightRepository fightRepository;
    private final DrawRepository drawRepository;
    private final CompetitorRepository competitorRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryAtCompetitionPdfReport.class);

    @Override
    public Fight saveFight(Fight fightToSave) {

        Draw draw = drawRepository.findDrawById(fightToSave.getDraw().getId());
        Fight fightFromDatabase = fightRepository.findFightByDrawAndNumberOfPlaceInDraw(draw, fightToSave.getNumberOfPlaceInDraw());
        Competitor firstCompetitor = competitorRepository.findCompetitorById(fightToSave.getFirstCompetitor().getId());
        Competitor secondCompetitor = competitorRepository.findCompetitorById(fightToSave.getSecondCompetitor().getId());

        if (fightFromDatabase == null) {
            fightToSave.setFirstCompetitor(firstCompetitor);
            fightToSave.setSecondCompetitor(secondCompetitor);
            fightToSave.setDraw(draw);
            return fightRepository.save(fightToSave);
        }
        if (secondCompetitor != null) {
            fightFromDatabase.setSecondCompetitor(secondCompetitor);
        }
        if (firstCompetitor != null) {
            fightFromDatabase.setFirstCompetitor(firstCompetitor);
        }
        fightFromDatabase.setWhoIsWinner(fightToSave.getWhoIsWinner());

        return fightRepository.save(fightFromDatabase);
    }

    @Override
    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }

    @Override
    public List<Fight> getFightsByDrawId(Long drawId) {
        Draw draw = drawRepository.findDrawById(drawId);
        List<Fight> fights = fightRepository.findFightsByDraw(draw);

        return fights.stream()
            .sorted(Comparator.comparing(Fight::getNumberOfPlaceInDraw))
            .toList();
    }
}
