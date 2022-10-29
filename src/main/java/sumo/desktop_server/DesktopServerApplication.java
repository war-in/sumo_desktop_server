package sumo.desktop_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sumo.desktop_server.Vendors.SumoWebServer.Conectivity.SumoWebServerConnector;
import sumo.desktop_server.Vendors.SumoWebServer.Schema.Security.SumoServerCredentials;
import sumo.desktop_server.Vendors.SumoWebServer.Schema.Security.SumoServerTokensRequest;

import java.util.HashMap;

@SpringBootApplication
public class DesktopServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(DesktopServerApplication.class, args);
    }

    @Configuration
    @EnableWebMvc
    public static class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*");
        }
    }

}
