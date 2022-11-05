package sumo.desktop_server.Database.ActualLogedUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActualLoggedUserServiceImpl implements ActualLoggedUserService {

    private final ActualLoggedUserRepository actualLoggedUserRepository;

    @Override
    public ActualLoggedUser getActualLoggedUser() {
        return actualLoggedUserRepository.findAllBy();
    }
}
