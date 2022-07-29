package sumo.desktop_server.Database.Category;

import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;
import sumo.desktop_server.Database.Sex.Sex;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CATEGORY_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "AGE_CATEGORY_ID")
    private AgeCategory ageCategory;

    @Column(name = "WEIGHT_CATEGORY")
    private String weightCategory;

    @ManyToOne
    @JoinColumn(name = "SEX")
    private Sex sex;
}
