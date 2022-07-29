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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "REGISTRATION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_AT_COMPETITION_ID")
    private CategoryAtCompetition categoryAtCompetition;

    @ManyToOne
    @JoinColumn(name = "COMPETITIOR_ID")
    private Competitor competitor;
}
