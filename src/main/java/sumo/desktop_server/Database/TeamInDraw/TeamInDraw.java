package sumo.desktop_server.Database.TeamInDraw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Country.Country;
import sumo.desktop_server.Database.Draw.Draw;

import javax.persistence.*;

@Entity
@Table(name = "TEAMS_IN_DRAWS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamInDraw {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TEAM_IN_DRAW_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_1")
    private Competitor competitor1;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_2")
    private Competitor competitor2;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_3")
    private Competitor competitor3;

    @ManyToOne
    @JoinColumn(name = "RESERVE_COMPETITOR")
    private Competitor reserveCompetitor;

    @Column(name = "NUMBER_OF_CHANGED_COMPETITOR")
    private int numberOfChangedCompetitor;
}
