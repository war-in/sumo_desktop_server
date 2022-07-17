package sumo.desktop_server.Database.WeightedCompetitor;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.Registrations.Registration;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WEIGHTED_COMPETITIORS")
@Getter
@Setter
public class WeightedCompetitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "WEIGHTED_COMPETITIOR_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "REGISTRATION_ID")
    private Registration registration;

    @Column(name = "WEIGHT")
    private float weight;

    @Column(name = "DATE")
    private LocalDate date;
}
