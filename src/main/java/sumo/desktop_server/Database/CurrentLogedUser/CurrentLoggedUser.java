package sumo.desktop_server.Database.CurrentLogedUser;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURENT_LOGGED_USER")
@Getter
@Setter
public class CurrentLoggedUser {

    @Id
    @Column(name = "USERNAME")
    private String username;

}
