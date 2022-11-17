package sumo.desktop_server.Database.SeciurityTokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import sumo.desktop_server.Database.CurrentLogedUser.CurrentLoggedUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SECURITY_TOKENS")
@Getter
@Setter
public class SecurityTokens {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private CurrentLoggedUser user;

    @Column(name = "ACCESS_TOKEN")
    @JsonProperty("access_token")
    private String accessToken;

    @Column(name="REFRESH_TOKEN")
    @JsonProperty("refresh_token")
    private String refreshToken;
}
