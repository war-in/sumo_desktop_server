package sumo.desktop_server.Database.Draw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.DrawType.DrawType;

import javax.persistence.*;

@Entity
@Table(name = "DRAWS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
