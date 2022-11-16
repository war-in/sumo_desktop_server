package sumo.desktop_server.Database.Registrations;

public interface RegistrationService {
    Registration getRegistrationByCategoryAtCompetitionIdAndCompetitorId(Long categoryAtCompetitionId, Long competitorId);
    Registration addRegistrationToCompetitor(Long categoryAtCompetitionId, Long competitorId);
    long removeRegistrationFromCompetitor(Long categoryAtCompetitionId, Long competitorId);
}
