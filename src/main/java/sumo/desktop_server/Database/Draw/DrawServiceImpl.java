package sumo.desktop_server.Database.Draw;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;
import sumo.desktop_server.Controllers.Utils.Draw.DataToSaveDraw;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDrawRepository;
import sumo.desktop_server.Database.DrawType.DrawType;
import sumo.desktop_server.Database.DrawType.DrawTypeRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DrawServiceImpl implements DrawService {

    private final DrawTypeRepository drawTypeRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final DrawRepository drawRepository;
    private final CompetitorInDrawRepository competitorInDrawRepository;

    @Override
    public List<?> prepareDraw(CompetitorsAndDrawType competitorsAndDrawType) {
        DrawType drawType = drawTypeRepository.findDrawTypeById(competitorsAndDrawType.getDrawType().getId());
        List<Competitor> competitors = competitorsAndDrawType.getCompetitors();
        int numOfCompetitorsWithoutGroups = competitors.size();

        if (drawType.getNumberOfCompetitors() <= 5) {
            Collections.shuffle(competitors);

            return List.of(competitors);
        }

        if (drawType.getNumberOfCompetitors() <= 10) {
            return splitRunnerUpAndMaster(competitors);
        }
        else {
            int numOfFreeFights = drawType.getNumberOfCompetitors() - numOfCompetitorsWithoutGroups;

            while (numOfFreeFights > 0) {
                competitors.add(new Competitor(null, null, null, "FreeFight"));
                numOfFreeFights--;
            }

            List<List<Competitor>> groups = splitRunnerUpAndMaster(competitors);

            return List.of(createGroups(groups.get(0)), createGroups(groups.get(1)));
        }
    }

    @Override
    public Draw saveDraw(DataToSaveDraw dataToSaveDraw) {
        DrawType drawType = drawTypeRepository.findDrawTypeById(dataToSaveDraw.getDrawType().getId());
        CategoryAtCompetition categoryAtCompetition = categoryAtCompetitionRepository.findCategoryAtCompetitionById(dataToSaveDraw.getCategoryAtCompetition().getId());

        Draw draw = drawRepository.save(new Draw(0, categoryAtCompetition, drawType));

        List<Competitor> competitors = dataToSaveDraw.getCompetitors();

        int index = 0;
        competitors.forEach(competitor -> {
            CompetitorInDraw competitorInDraw = new CompetitorInDraw(0, draw, competitor, index);
            competitorInDrawRepository.save(competitorInDraw);
        });

        return draw;
    }

    private List<List<Competitor>> splitRunnerUpAndMaster(List<Competitor> competitors) {
        Competitor master = competitors.get(0);
        Competitor runnerUp = competitors.get(1);

        competitors.remove(1);
        competitors.remove(0);

        List<List<Competitor>> groups = divide(competitors);
        groups.get(0).add(master);
        groups.get(1).add(runnerUp);

        Collections.shuffle(groups.get(0));
        Collections.shuffle(groups.get(1));
        Collections.shuffle(groups);

        return groups;
    }

    private List<?> createGroups(List<Competitor> competitors) {
        if (competitors.size() == 2) {
            Collections.shuffle(competitors);
            return competitors;
        }

        List<List<Competitor>> groups = divide(competitors);
        List<?> group1 = createGroups(groups.get(0));
        List<?> group2 = createGroups(groups.get(1));

        return List.of(group1, group2);
    }

    private List<List<Competitor>> divide(List<Competitor> competitors) {
        int numOfCompetitorsWithoutGroups = competitors.size();

        List<List<Competitor>> groups = new ArrayList<>();
        groups.add(new ArrayList<>());
        groups.add(new ArrayList<>());

        Map<String, List<Competitor>> competitorsByCountries = competitors.stream().collect(Collectors.groupingBy(Competitor::getCountry));

        List<List<Competitor>> sortedCompetitorsByCountries = competitorsByCountries.values().stream()
                .sorted(Comparator.comparingInt(List::size)).toList();

        boolean isFirstGroup = true;
        int bucketIndex = 0;
        while (numOfCompetitorsWithoutGroups > 0) {

            while (sortedCompetitorsByCountries.get(bucketIndex).size() > 0) {
                groups.get(isFirstGroup ? 1:0).add(sortedCompetitorsByCountries.get(bucketIndex).get(0));
                sortedCompetitorsByCountries.get(bucketIndex).remove(0);

                isFirstGroup = !isFirstGroup;
                numOfCompetitorsWithoutGroups -= 1;
            }
            bucketIndex += 1;
        }

        Collections.shuffle(groups.get(0));
        Collections.shuffle(groups.get(1));
        Collections.shuffle(groups);

        return groups;
    }
}
