package sumo.desktop_server.Database.DrawType;

import sumo.desktop_server.Database.Region.Region;

import java.util.List;

public interface DrawTypeService {
    List<DrawType> getDrawTypesAboveSpecifiedNumberOfCompetitors(Long numberOfCompetitors, String region);
}
