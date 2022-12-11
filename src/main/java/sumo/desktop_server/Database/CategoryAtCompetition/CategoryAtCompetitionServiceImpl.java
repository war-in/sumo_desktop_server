package sumo.desktop_server.Database.CategoryAtCompetition;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Draw.DrawRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryAtCompetitionServiceImpl implements CategoryAtCompetitionService {
    final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    final DrawRepository drawRepository;
    @Override
    public CategoryAtCompetition findCategoryAtCompetitionById(Long id) {
        return categoryAtCompetitionRepository.findCategoryAtCompetitionById(id);
    }


}
