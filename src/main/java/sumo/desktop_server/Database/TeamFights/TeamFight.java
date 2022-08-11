package sumo.desktop_server.Database.TeamFights;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Country.Country;
import sumo.desktop_server.Database.Draw.Draw;

import javax.persistence.*;

@Entity
@Table(name = "TEAM_FIGHTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamFight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TEAM_FIGHT_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @ManyToOne
    @JoinColumn(name = "FIRST_COUNTRY_ID")
    private Country firstCountry;

    @ManyToOne
    @JoinColumn(name = "SECOND_COUNTRY_ID")
    private Country secondCountry;

    @Column(name = "WINNER")
    private boolean winner;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;
}
