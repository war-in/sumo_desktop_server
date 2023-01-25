package sumo.desktop_server.Database.AgeCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeCategoryRepository extends JpaRepository<AgeCategory,Long> {
    AgeCategory findAgeCategoryById(Long id);
}
