package sumo.desktop_server.Database.Fight;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Draw.Draw;

import javax.persistence.*;

@Entity
@Table(name = "FIGHTS")
@Getter
@Setter
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FIGHT_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @ManyToOne
    @JoinColumn(name = "FIRST_COMPETIROR_ID")
    private Competitor firstCompetitor;

    @ManyToOne
    @JoinColumn(name = "SECOND_COMPETITOR")
    private Competitor secondCompetitor;

    @Column(name = "WINNER")
    private boolean winner;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;
}
