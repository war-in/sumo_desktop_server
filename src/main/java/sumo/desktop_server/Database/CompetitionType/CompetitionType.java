package sumo.desktop_server.Database.CompetitionType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETITION_TYPES")
@Getter
@Setter
public class CompetitionType {

    @Id
    @Column(name = "TYPE")
    private String type;
}
