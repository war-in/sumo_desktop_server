package sumo.desktop_server.Database.WeighedCompetitor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;
import sumo.desktop_server.Database.Registrations.Registration;
import sumo.desktop_server.Database.Registrations.RegistrationRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WeighedCompetitorServiceImpl implements WeighedCompetitorService{

    private final RegistrationRepository registrationRepository;
    private final WeighedCompetitorRepository weighedCompetitorRepository;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final CompetitorRepository competitorRepository;

    @Override
    public WeighedCompetitor getCompetitorsWeighingDetailsAtSpecifiedCategory(Long categoryAtCompetitionId, Long competitorId) {
        CategoryAtCompetition category = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        Competitor competitor = competitorRepository.findCompetitorById(competitorId);

        Registration registration = registrationRepository.findRegistrationByCategoryAtCompetitionAndCompetitor(category, competitor);

        return weighedCompetitorRepository.findWeighedCompetitorByRegistrationId(registration.getId());
    }

    @Override
    public WeighedCompetitor setWeighingDetails(WeighedCompetitor weighedCompetitor) {
        LocalDate date = LocalDate.now();
        weighedCompetitor.setDate(date);

        return weighedCompetitorRepository.save(weighedCompetitor);
    }
}
