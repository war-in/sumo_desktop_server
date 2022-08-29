package sumo.desktop_server.Database.TeamFight;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.TeamInDraw.TeamInDraw;

import javax.persistence.*;

@Entity
@Table(name = "TEAM_FIGHTS")
@Getter
@Setter
public class TeamFight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TEAM_FIGHT_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @ManyToOne
    @JoinColumn(name = "FIRST_TEAM_IN_DRAW")
    private TeamInDraw firstTeam;

    @ManyToOne
    @JoinColumn(name = "SECOND_TEAM_IN_DRAW")
    private TeamInDraw secondTeam;


    @Column(name = "WINNER")
    private boolean winner;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;

}
