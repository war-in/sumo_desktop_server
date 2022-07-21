package sumo.desktop_server.Database.Competition;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Registrations.Registration;
import sumo.desktop_server.Database.Registrations.RegistrationRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompetitionServiceImpl implements CompetitionService {

    private final RegistrationRepository registrationRepository;
    private final CompetitionRepository competitionRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;

    @Override
    public List<Competitor> getAllCompetitors(Long competitionId) {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        List<CategoryAtCompetition> categories = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);

        HashSet<Competitor> competitors = new HashSet<>();
        categories.forEach(categoryAtCompetition -> {
            List<Registration> registrations = registrationRepository.findRegistrationsByCategoryAtCompetition(categoryAtCompetition);

            registrations.forEach(registration -> competitors.add(registration.getCompetitor()));
        });

        return competitors.stream().toList();
    }
}
