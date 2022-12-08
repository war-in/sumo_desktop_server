package sumo.desktop_server.Database.Draw;

import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Controllers.Utils.Draw.CompetitorsAndDrawType;
import sumo.desktop_server.Controllers.Utils.Draw.DataToSaveDraw;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDrawRepository;
import sumo.desktop_server.Database.DrawType.DrawType;
import sumo.desktop_server.Database.DrawType.DrawTypeRepository;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Fight.FightService;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DrawServiceImpl implements DrawService {

    private final DrawTypeRepository drawTypeRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final DrawRepository drawRepository;
    private final CompetitorInDrawRepository competitorInDrawRepository;
    private final CompetitorRepository competitorRepository;
    private final FightService fightService;

    @Override
    public List<Competitor> prepareDraw(CompetitorsAndDrawType competitorsAndDrawType) {
        DrawType drawType = drawTypeRepository.findDrawTypeById(competitorsAndDrawType.getDrawType().getId());
        List<Competitor> competitors = competitorsAndDrawType.getCompetitors();
        int numOfCompetitorsWithoutGroups = competitors.size();

        if (drawType.getNumberOfCompetitors() <= 5) {
            Collections.shuffle(competitors);

            return competitors;
        }

        if (drawType.getNumberOfCompetitors() == 10) {
            return splitRunnerUpAndMaster(competitors).stream().flatMap(List::stream).toList();
        }
        else {
            int numOfFreeFights = drawType.getNumberOfCompetitors() - numOfCompetitorsWithoutGroups;

            while (numOfFreeFights > 0) {
                competitors.add(competitorRepository.findCompetitorById(0L));
                numOfFreeFights--;
            }

            List<List<Competitor>> groups = splitRunnerUpAndMaster(competitors);

            return flattenNestedLists(List.of(createGroups(groups.get(0)), createGroups(groups.get(1))));
        }
    }

    @Override
    public Draw saveDraw(DataToSaveDraw dataToSaveDraw) {
        DrawType drawType = drawTypeRepository.findDrawTypeById(dataToSaveDraw.getDrawType().getId());
        CategoryAtCompetition categoryAtCompetition =
            categoryAtCompetitionRepository.findCategoryAtCompetitionById(
                dataToSaveDraw.getCategoryAtCompetitionId());

        Draw drawFromDatabase = drawRepository.findDrawById(categoryAtCompetition.getId());
        if (drawFromDatabase == null)
            drawFromDatabase = new Draw(categoryAtCompetition.getId(), categoryAtCompetition, drawType);

        Draw draw = drawRepository.save(drawFromDatabase);

        List<Competitor> competitors = dataToSaveDraw.getCompetitors();

        for (int i=0; i<competitors.size(); i++) {
            CompetitorInDraw competitorInDraw = new CompetitorInDraw();
            competitorInDraw.setDraw(draw);
            competitorInDraw.setCompetitor(competitors.get(i));
            competitorInDraw.setNumberOfPlaceInDraw(i);

            competitorInDrawRepository.save(competitorInDraw);
        }

        return draw;
    }

    @Override
    public List<Competitor> getCompetitorsInDraw(Long drawId) {
        Draw draw = drawRepository.findDrawById(drawId);
        System.out.println(draw);
        List<CompetitorInDraw> competitorInDraw = competitorInDrawRepository.findAllByDraw(draw);

        return competitorInDraw.stream()
                .sorted(Comparator.comparing(CompetitorInDraw::getNumberOfPlaceInDraw))
                .map(CompetitorInDraw::getCompetitor).toList();
    }

    @Override
    public JSONObject getDrawsDetailsByCompetition(Competition competition) {
        List<Draw> draws = getAllDrawsAtTheCompetition(competition);

        List<JSONObject> dataset = new ArrayList<>();
        draws.forEach(draw -> {
            JSONObject categoryData = new JSONObject();
            categoryData.appendField("weight", draw.getCategoryAtCompetition().getCategory().getWeightCategory());
            categoryData.appendField("age", draw.getCategoryAtCompetition().getCategory().getAgeCategory().getName());
            categoryData.appendField("sex", draw.getCategoryAtCompetition().getCategory().getSex().getSex());
            categoryData.appendField("id", draw.getId());

            dataset.add(categoryData);
        });

        JSONObject result = new JSONObject();
        result.appendField("dataset", dataset);
        result.appendField("draws", draws);

        return result;
    }

    @Override
    public JSONObject getEndedDrawsByCompetition(Competition competition) {
        List<Draw> draws = getAllDrawsAtTheCompetition(competition);
        List<Draw> endedDraws = getEndedDraws(draws);

        System.out.println(endedDraws);

        List<JSONObject> dataset = new ArrayList<>();
        endedDraws.forEach(draw -> {
            JSONObject categoryData = new JSONObject();
            categoryData.appendField("weight", draw.getCategoryAtCompetition().getCategory().getWeightCategory());
            categoryData.appendField("age", draw.getCategoryAtCompetition().getCategory().getAgeCategory().getName());
            categoryData.appendField("sex", draw.getCategoryAtCompetition().getCategory().getSex().getSex());
            categoryData.appendField("id", draw.getId());

            dataset.add(categoryData);
        });

        JSONObject result = new JSONObject();
        result.appendField("dataset", dataset);

        return result;
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

    private List<Competitor> flattenNestedLists(List<List<?>> nestedList) {
        List<?> flattenedList = nestedList.stream().flatMap(List::stream).toList();

        if(flattenedList.get(0) instanceof List)
            return this.flattenNestedLists((List<List<?>>) flattenedList);

        return (List<Competitor>) flattenedList;
    }

    private List<Draw> getAllDrawsAtTheCompetition(Competition competition) {
        List<Draw> allDraws = drawRepository.findAllBy();
        return allDraws.stream().filter(draw -> draw.getCategoryAtCompetition().getCompetition() == competition).toList();
    }

    private List<Draw> getEndedDraws(List<Draw> draws) {
        return draws.stream().filter(this::isDrawEnded).toList();
    }

    private boolean isDrawEnded(Draw draw) {
        List<Fight> fights = fightService.getFightsByDrawId(draw.getId());
        System.out.println(fights.stream().filter(fight -> fight.getWhoIsWinner() == 0).toList());
        return fights.stream().filter(fight -> fight.getWhoIsWinner() == 0 && fight.getFirstCompetitor() != null).toList().size() == 0;
    }
}
