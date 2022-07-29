package sumo.desktop_server.Database.Region;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, String> {
    Region findRegionByRegion(String region);
}
