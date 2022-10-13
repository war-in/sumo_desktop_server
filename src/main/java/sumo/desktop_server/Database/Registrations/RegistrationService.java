package sumo.desktop_server.Database.Registrations;

public interface RegistrationService {
    Registration getRegistrationByCategoryAtCompetitionIdAndCompetitorId(Long categoryAtCompetitionId, Long competitorId);
}
