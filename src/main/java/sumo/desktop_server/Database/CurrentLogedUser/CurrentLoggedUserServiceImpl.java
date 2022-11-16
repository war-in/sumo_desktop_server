package sumo.desktop_server.Database.CurrentLogedUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CurrentLoggedUserServiceImpl implements CurrentLoggedUserService {

    private final CurrentLoggedUserRepository currentLoggedUserRepository;

    @Override
    public CurrentLoggedUser getActualLoggedUser() {
        return currentLoggedUserRepository.findAllBy();
    }
}
