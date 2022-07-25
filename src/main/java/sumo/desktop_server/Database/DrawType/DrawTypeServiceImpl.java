package sumo.desktop_server.Database.DrawType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.Region.Region;
import sumo.desktop_server.Database.Region.RegionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DrawTypeServiceImpl implements DrawTypeService {

    private final DrawTypeRepository drawTypeRepository;
    private final RegionRepository regionRepository;

    @Override
    public List<DrawType> getDrawTypesAboveSpecifiedNumberOfCompetitors(Long numberOfCompetitors, String regionName) {
        Region region = regionRepository.findRegionByRegion(regionName);
        List<DrawType> allDrawTypes = drawTypeRepository.findDrawTypesByRegion(region);

        return allDrawTypes.stream().filter(drawType -> drawType.getNumberOfCompetitors() >= numberOfCompetitors).toList();
    }
}
