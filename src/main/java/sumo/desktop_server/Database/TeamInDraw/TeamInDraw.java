package sumo.desktop_server.Database.TeamInDraw;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Draw.Draw;

import javax.persistence.*;

@Entity
@Table(name = "TEAMS_IN_DRAWS")
@Getter
@Setter
public class TeamInDraw {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TEAM_IN_DRAW_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;

    @ManyToOne
    @JoinColumn(name = "FIRST_COMPETITOR_ID")
    private Competitor firstCompetitor;

    @ManyToOne
    @JoinColumn(name = "SECOND_COMPETITOR")
    private Competitor secondCompetitor;

    @ManyToOne
    @JoinColumn(name = "THIRD_COMPETITOR")
    private Competitor thirdCompetitor;

    @ManyToOne
    @JoinColumn(name = "SUB_COMPETITOR")
    private Competitor subCompetitor;

    @Column(name = "NUMBER_OF_CHANGED_PLAYER")
    private int numberOfChangedPlayer;
}
