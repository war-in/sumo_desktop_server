package sumo.desktop_server.Database.Registrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitor;
import sumo.desktop_server.Database.WeighedCompetitor.WeighedCompetitorRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final CompetitorRepository competitorRepository;
    private final WeighedCompetitorRepository weighedCompetitorRepository;

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
        WeighedCompetitor weighedCompetitor = new WeighedCompetitor();
        weighedCompetitor.setRegistration(newRegistration);
        weighedCompetitorRepository.save(weighedCompetitor);
        return registrationRepository.save(newRegistration);
    }

    @Override
    public void removeRegistrationFromCompetitor(Long categoryAtCompetitionId, Long competitorId) {
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);
        CategoryAtCompetition category = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        Registration registration = registrationRepository.findRegistrationByCategoryAtCompetitionAndCompetitor(category,competitor);
        weighedCompetitorRepository.deleteWeighedCompetitorByRegistration(registration);
        registrationRepository.delete(registration);
    }


}
