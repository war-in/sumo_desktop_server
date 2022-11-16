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

    @Override
    public Registration addRegistrationToCompetitor(Long categoryAtCompetitionId, Long competitorId) {
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);
        CategoryAtCompetition category = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        Registration newRegistration = new Registration();
        newRegistration.setCompetitor(competitor);
        newRegistration.setCategoryAtCompetition(category);
        return registrationRepository.save(newRegistration);
    }

    @Override
    public long removeRegistrationFromCompetitor(Long categoryAtCompetitionId, Long competitorId) {
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);
        CategoryAtCompetition category = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        return registrationRepository.deleteByCategoryAtCompetitionAndCompetitor(category,competitor);
    }


}
