package sumo.desktop_server.Database.Draw;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.DrawType.DrawType;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DRAWS")
@Getter
@Setter
public class Draw {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DRAW_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_AT_COMPETITION_ID")
    private CategoryAtCompetition categoryAtCompetition;

    @ManyToOne
    @JoinColumn(name = "DRAW_TYPE_ID")
    private DrawType drawType;
}
