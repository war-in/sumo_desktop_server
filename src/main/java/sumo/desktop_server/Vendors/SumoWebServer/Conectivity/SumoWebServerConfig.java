package sumo.desktop_server.Vendors.SumoWebServer.Conectivity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.reactive.function.client.WebClient;
import sumo.desktop_server.Database.SeciurityTokens.SecurityTokenService;

@Configuration
public class SumoWebServerConfig {

    @Value("sumoWebServiceLink")
    private String SUMO_SERVER_LINK;

    @Bean
    SumoWebServerConnector sumoWebServerConnector(WebClient sumoServerWebClient, SecurityTokenService securityTokenService) {
        return new SumoWebServerConnector(sumoServerWebClient,securityTokenService);
    }

    @Bean
    WebClient sumoServerWebClient() {
        return WebClient.builder().baseUrl(SUMO_SERVER_LINK).build();
    }

    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
