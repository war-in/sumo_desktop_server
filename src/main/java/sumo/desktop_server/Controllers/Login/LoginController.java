package sumo.desktop_server.Controllers.Login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Fight.FightService;
import sumo.desktop_server.Vendors.SumoWebServer.Conectivity.SumoWebServerConnector;
import sumo.desktop_server.Vendors.SumoWebServer.Schema.Security.SumoServerCredentials;

import java.util.List;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final SumoWebServerConnector sumoWebServerConnector;
    @GetMapping
    public void login(@RequestBody SumoServerCredentials sumoServerCredentials){
        sumoWebServerConnector.getTokens(sumoServerCredentials.getUsername(),sumoServerCredentials.getPassword());
    }

}
