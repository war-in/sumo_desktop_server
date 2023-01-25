package sumo.desktop_server.Database.PointsClassification;


import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;
import sumo.desktop_server.Database.Competition.Competition;

import javax.persistence.*;

@Entity
@Table(name = "POINTS_CLASSIFICATIONS")
@Getter
@Setter
public class PointsClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "POINT_CLASSIFICATION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COMPETITION_ID")
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "AGE_CATEGORY_ID")
    private AgeCategory ageCategory;

    @Column(name = "PLACEMENT_ON_COMPETITION")
    private int placement;

    @Column(name = "NUMBER_OF_POINTS")
    private int numberOfPoints;


}
