package sumo.desktop_server.Database.Competitor;

import lombok.*;
import sumo.desktop_server.Database.Sex.Sex;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONAL_DETAILS")
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "LINK_TO_PROFILE_PICTURE")
    private String linkToProfilePicture;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SEX")
    private Sex sex;
}
