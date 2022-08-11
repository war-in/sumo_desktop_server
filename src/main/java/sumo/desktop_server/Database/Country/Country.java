package sumo.desktop_server.Database.Country;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
public class Country {

    @Id
    @Column(name = "COUNTRY")
    private String country;
}
