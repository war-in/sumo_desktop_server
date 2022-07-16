package sumo.desktop_server.Database.AgeCategory;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AGE_CATEGORIES")
@Getter
@Setter
public class AgeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AGE_CATEGORY_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "OLDEST_COMPETITOR_BIRTH_YEAR")
    private LocalDate oldestCompetitorBirthYear;

    @Column(name = "YOUNGEST_COMPETITOR_BIRTH_YEAR")
    private LocalDate youngestCompetitorBirthYear;
}
