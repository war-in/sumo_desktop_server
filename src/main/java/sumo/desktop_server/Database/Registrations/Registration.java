package sumo.desktop_server.Database.Registrations;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.Competitor.Competitor;

import javax.persistence.*;

@Entity
@Table(name = "REGISTRATIONS")
@Getter
@Setter
public class Registration {

    @Id
    @SequenceGenerator(name = "registration_id_seq",
        sequenceName = "registration_id_seq",
        initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "registration_id_seq")
    @Column(name = "REGISTRATION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_AT_COMPETITION_ID")
    private CategoryAtCompetition categoryAtCompetition;

    @ManyToOne
    @JoinColumn(name = "COMPETITIOR_ID")
    private Competitor competitor;
}
