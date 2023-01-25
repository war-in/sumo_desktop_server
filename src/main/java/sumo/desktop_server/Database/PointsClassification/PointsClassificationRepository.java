package sumo.desktop_server.Database.PointsClassification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointsClassificationRepository extends JpaRepository<PointsClassification,Long> {
    List<PointsClassification> findPointsClassificationsByCompetitionIdAndAgeCategoryId(Long competitionId,Long ageCategoryId);
    List<PointsClassification> findPointsClassificationsByCompetitionId(Long competitionId);
}
