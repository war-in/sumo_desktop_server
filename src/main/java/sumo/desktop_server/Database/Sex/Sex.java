package sumo.desktop_server.Database.Sex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEXES")
@Getter
@Setter
public class Sex {

    @Id
    @Column(name = "SEX")
    private String sex;
}
