package sumo.desktop_server.Database.Competition;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.CompetitionType.CompetitionType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "COMPETITIONS")
@Getter
@Setter
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITION_ID")
    private long id;

    @Column(name = "ID_FROM_SERVER")
    private long idFromServer;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "TYPE")
    private CompetitionType type;
}
