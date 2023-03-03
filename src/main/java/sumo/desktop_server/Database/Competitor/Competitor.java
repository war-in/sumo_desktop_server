package sumo.desktop_server.Database.Competitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMPETITORS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITOR_ID")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;

    @Column(name = "STATUS")
    private CompetitorsStatus status;

    @Column(name = "COUNTRY")
    private String country;

    private Boolean isWeighted;
}
