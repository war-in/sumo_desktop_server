package sumo.desktop_server.Database.SeciurityTokens;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecurityTokensServiceImpl implements SecurityTokenService{

    private final SecurityTokensRepository securityTokensRepository;

    @Override
    public SecurityTokens getSecurityTokens() {
        return securityTokensRepository.findAllBy();
    }
}
