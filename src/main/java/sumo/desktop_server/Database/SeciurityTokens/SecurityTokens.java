package sumo.desktop_server.Database.SeciurityTokens;

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
public class SecurityTokens {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TOKEN_ID")
    private long id;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name="REFRESH_TOKEN")
    private String refreshToken;

    @Column(name="EXPIRATION")
    private String expiration;
}
