package sumo.desktop_server.Database.DrawType;

import org.springframework.data.jpa.repository.JpaRepository;
import sumo.desktop_server.Database.Region.Region;

import java.util.List;

public interface DrawTypeRepository extends JpaRepository<DrawType, Long> {
    List<DrawType> findDrawTypesByRegion(Region region);
    DrawType findDrawTypeById(Long id);
}
