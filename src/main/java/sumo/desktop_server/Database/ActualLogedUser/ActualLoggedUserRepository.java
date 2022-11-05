package sumo.desktop_server.Database.ActualLogedUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActualLoggedUserRepository extends JpaRepository<ActualLoggedUser, Long> {
    ActualLoggedUser findAllBy();
}
