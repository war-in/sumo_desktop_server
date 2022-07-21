package sumo.desktop_server.Database.Competitor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.Category.Category;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.Competition.CompetitionRepository;
import sumo.desktop_server.Database.Registrations.Registration;
import sumo.desktop_server.Database.Registrations.RegistrationRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompetitorServiceImpl implements CompetitorService {

    private final RegistrationRepository registrationRepository;
    private final CompetitionRepository competitionRepository;
    private final CompetitorRepository competitorRepository;

    @Override
    public List<Category> getCompetitorCategoriesAtSpecifiedCompetition(Long competitorId, Long competitionId) {
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);
        Competition competition = competitionRepository.findCompetitionById(competitionId);

        List<Registration> registrations = registrationRepository.findRegistrationsByCompetitor(competitor);
        registrations = registrations.stream().filter(registration -> registration.getCategoryAtCompetition().getCompetition().equals(competition)).toList();

        List<Category> categories = new ArrayList<>();
        registrations.forEach(registration -> categories.add(registration.getCategoryAtCompetition().getCategory()));

        return categories;
    }
}
