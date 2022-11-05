package sumo.desktop_server.Database.ActualLogedUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECIURITY_TOKENS")
@Getter
@Setter
public class ActualLoggedUser {

    @Id
    @Column(name = "USERNAME")
    private String username;

}
