package sumo.desktop_server.Database.DrawType;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.Region.Region;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DRAW_TYPES")
@Getter
@Setter
public class DrawType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DRAW_TYPE_ID")
    private long id;

    @Column(name = "NUMBER_OF_COMPETITORS")
    private int numberOfCompetitors;

    @ManyToOne
    @JoinColumn(name = "REGION")
    private Region region;
}
