package sumo.desktop_server.Database.CompetitorInDraw;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Draw.Draw;

import javax.persistence.*;

@Entity
@Table(name = "COMPETITORS_IN_DRAWS")
@Getter
@Setter
public class CompetitorInDraw {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITOR_IN_DRAW_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_ID")
    private Competitor competitor;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;
}
