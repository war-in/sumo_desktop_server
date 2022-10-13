package sumo.desktop_server.Database.WeighedCompetitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sumo.desktop_server.Database.Registrations.Registration;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WEIGHED_COMPETITORS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeighedCompetitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "WEIGHED_COMPETITOR_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "REGISTRATION_ID")
    private Registration registration;

    @Column(name = "WEIGHT")
    private float weight;

    @Column(name = "DATE")
    private LocalDate date;
}
