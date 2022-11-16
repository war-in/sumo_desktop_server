package sumo.desktop_server.Database.CurrentLogedUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentLoggedUserRepository extends JpaRepository<CurrentLoggedUser, Long> {
    CurrentLoggedUser findAllBy();
}
