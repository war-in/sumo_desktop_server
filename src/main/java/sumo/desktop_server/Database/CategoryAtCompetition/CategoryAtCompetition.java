package sumo.desktop_server.Database.CategoryAtCompetition;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.Category.Category;
import sumo.desktop_server.Database.Competition.Competition;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES_AT_COMPETITIONS")
@Getter
@Setter
public class CategoryAtCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CATEGORY_AT_COMPETITION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COMPETITION_ID")
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
