package sumo.desktop_server.Database.SeciurityTokens;

public interface SecurityTokenService {
    SecurityTokens getSecurityTokens();
    SecurityTokens saveSecurityTokens(SecurityTokens securityTokens);
}
