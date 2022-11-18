package sumo.desktop_server.Database.SeciurityTokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SecurityTokens {

    @Id
    private String currentLoggedUser;

    @Column(name = "ACCESS_TOKEN")
    @JsonProperty("access_token")
    private String accessToken;

    @Column(name="REFRESH_TOKEN")
    @JsonProperty("refresh_token")
    private String refreshToken;
}
