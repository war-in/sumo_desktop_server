package sumo.desktop_server.Database.Registrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final CompetitorRepository competitorRepository;

    @Override
    public Registration getRegistrationByCategoryAtCompetitionIdAndCompetitorId(Long categoryAtCompetitionId, Long competitorId) {
        CategoryAtCompetition category = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);

        return registrationRepository.findRegistrationByCategoryAtCompetitionAndCompetitor(category, competitor);
    }
}
