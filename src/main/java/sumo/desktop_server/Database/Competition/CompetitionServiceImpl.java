package sumo.desktop_server.Database.Competition;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Controllers.Utils.Draw.CategoryAndCompetitors;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Registrations.Registration;
import sumo.desktop_server.Database.Registrations.RegistrationRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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

    @Override
    public List<CategoryAndCompetitors> getCategoriesAndCompetitors(Long competitionId) {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        List<CategoryAtCompetition> categoriesAtCompetition = categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);

        List<CategoryAndCompetitors> categoriesAndCompetitors = new ArrayList<>();
        categoriesAtCompetition.forEach(categoryAtCompetition -> {
            CategoryAndCompetitors categoryAndCompetitors = new CategoryAndCompetitors();
            categoryAndCompetitors.setCategory(categoryAtCompetition.getCategory());

            List<Registration> registrations = registrationRepository.findRegistrationsByCategoryAtCompetition(categoryAtCompetition);
            List<Competitor> competitors = new ArrayList<>();
            registrations.forEach(registration -> competitors.add(registration.getCompetitor()));

            categoryAndCompetitors.setCompetitors(competitors);

            categoriesAndCompetitors.add(categoryAndCompetitors);
        });

        return categoriesAndCompetitors;
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public List<CategoryAtCompetition> getCategoriesAtCompetition(Long competitionId) {
        Competition competition = competitionRepository.findCompetitionById(competitionId);
        return categoryAtCompetitionRepository.findCategoryAtCompetitionsByCompetition(competition);
    }
}
