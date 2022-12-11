package sumo.desktop_server.Database.Results;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Transactional
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final CompetitorRepository competitorRepository;

    @Override
    public void saveResults(Long categoryAtCompetitionId, List<Competitor> competitorsInOrder) {
        CategoryAtCompetition categoryAtCompetition = categoryAtCompetitionRepository
                .findCategoryAtCompetitionById(categoryAtCompetitionId);

        List<Result> results = resultRepository.findResultsByCategoryAtCompetition(categoryAtCompetition);

        results.forEach(result -> {
            Competitor competitor = competitorRepository.findCompetitorById(competitorsInOrder.get(result.getPlacement()).getId());
            result.setCompetitor(competitor);
        });

        AtomicInteger i = new AtomicInteger(results.size());
        competitorsInOrder.subList(results.size(), competitorsInOrder.size())
            .forEach(competitor -> {
                competitor = competitorRepository.findCompetitorById(competitor.getId());
                resultRepository.save(new Result(0, categoryAtCompetition, competitor, i.getAndIncrement()));
            });
    }

    @Override
    public List<Competitor> getCompetitorsByCategoryAtCompetitionId(Long categoryAtCompetitionId) {
        CategoryAtCompetition categoryAtCompetition = categoryAtCompetitionRepository
                .findCategoryAtCompetitionById(categoryAtCompetitionId);

        return resultRepository
                .findResultsByCategoryAtCompetition(categoryAtCompetition)
                .stream().sorted(Comparator.comparing(Result::getPlacement))
                .map(Result::getCompetitor).toList();
    }
    public List<Result> getResultsByCategoryAtCompetitionId(Long categoryAtCompetitionId) {
        CategoryAtCompetition categoryAtCompetition = categoryAtCompetitionRepository
                .findCategoryAtCompetitionById(categoryAtCompetitionId);

        return resultRepository
                .findResultsByCategoryAtCompetition(categoryAtCompetition)
                .stream().sorted(Comparator.comparing(Result::getPlacement))
                .toList();
    }
}
