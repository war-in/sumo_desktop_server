package sumo.desktop_server.Database.SeciurityTokens;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityTokensRepository extends JpaRepository<SecurityTokens, Long> {
    SecurityTokens findAllBy();
}
