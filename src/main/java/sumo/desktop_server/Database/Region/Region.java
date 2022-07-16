package sumo.desktop_server.Database.Region;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "REGIONS")
@Getter
@Setter
public class Region {

    @Id
    @Column(name = "REGION")
    private String region;
}
