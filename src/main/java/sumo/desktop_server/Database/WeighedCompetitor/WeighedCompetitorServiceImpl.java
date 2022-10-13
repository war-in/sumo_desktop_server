package sumo.desktop_server.Database.WeighedCompetitor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.CompetitorRepository;
import sumo.desktop_server.Database.Registrations.Registration;
import sumo.desktop_server.Database.Registrations.RegistrationRepository;
import sumo.desktop_server.Database.Registrations.RegistrationService;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class WeighedCompetitorServiceImpl implements WeighedCompetitorService{

    private final WeighedCompetitorRepository weighedCompetitorRepository;
    private final RegistrationService registrationService;

    @Override
    public WeighedCompetitor getCompetitorsWeighingDetailsAtSpecifiedCategory(Long categoryAtCompetitionId, Long competitorId) {
        Registration registration = registrationService
                .getRegistrationByCategoryAtCompetitionIdAndCompetitorId(categoryAtCompetitionId, competitorId);

        WeighedCompetitor weighedCompetitor = weighedCompetitorRepository
                .findWeighedCompetitorByRegistrationId(registration.getId());

        if (weighedCompetitor == null) {
            weighedCompetitor = new WeighedCompetitor();
            weighedCompetitor.setRegistration(registration);

            return weighedCompetitorRepository.save(weighedCompetitor);
        }

        return weighedCompetitor;
    }

    @Override
    public WeighedCompetitor setWeighingDetails(Long categoryAtCompetitionId, Long competitorId, Float weight) {
        WeighedCompetitor weighedCompetitor = this.getByCategoryAtCompetitionIdAndCompetitorId(categoryAtCompetitionId, competitorId);
        LocalDate date = LocalDate.now();

        weighedCompetitor.setWeight(weight);
        weighedCompetitor.setDate(date);

        return weighedCompetitorRepository.save(weighedCompetitor);
    }

    private WeighedCompetitor getByCategoryAtCompetitionIdAndCompetitorId(Long categoryAtCompetitionId, Long competitorId) {
        Registration registration = registrationService
                .getRegistrationByCategoryAtCompetitionIdAndCompetitorId(categoryAtCompetitionId, competitorId);

        return weighedCompetitorRepository.findWeighedCompetitorByRegistrationId(registration.getId());
    }
}
