package sumo.desktop_server.Database.Registrations;

public interface RegistrationService {
    Registration getRegistrationByCategoryAtCompetitionIdAndCompetitorId(Long categoryAtCompetitionId, Long competitorId);
    Registration addRegistrationToCompetitor(Long categoryAtCompetitionId, Long competitorId);
    void removeRegistrationFromCompetitor(Long categoryAtCompetitionId, Long competitorId);
}
