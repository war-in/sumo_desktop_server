package sumo.desktop_server.Database.SeciurityTokens;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityTokenServiceImpl implements SecurityTokenService{

    private final SecurityTokensRepository securityTokensRepository;

    @Override
    public SecurityTokens getSecurityTokens() {
        return securityTokensRepository.findAllBy();
    }

    @Override
    public SecurityTokens saveSecurityTokens(SecurityTokens securityTokens) {
        securityTokensRepository.deleteAll();
        return securityTokensRepository.save(securityTokens);
    }
}
