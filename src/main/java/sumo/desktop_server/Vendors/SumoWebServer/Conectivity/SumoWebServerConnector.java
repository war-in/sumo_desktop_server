package sumo.desktop_server.Vendors.SumoWebServer.Conectivity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import sumo.desktop_server.Database.SeciurityTokens.SecurityTokenService;
import sumo.desktop_server.Database.SeciurityTokens.SecurityTokens;

import java.util.Map;

@RequiredArgsConstructor
public class SumoWebServerConnector {

    private final WebClient webClient;
    private final SecurityTokenService securityTokenService;

    @Value("sumoWebServiceLink")
    private String SUMO_SERVER_LINK;
    @Value("sumoWebService.GetTokenEndpoint")
    private String LOGIN_ENDPOINT;
    @Value("sumoWebService.RefreshTokenLink")
    private String REFRESH_TOKEN_ENDPOINT;


    public WebClient.ResponseSpec send(RequestEntity<?> request, HttpMethod method) {
        return prepareRequestToSend(request, method).retrieve();
    }

    public <ResponseClass> ResponseClass sendRequest(RequestEntity<?> request, String endpoint, HttpMethod method, ResponseClass responseClass) {
        ResponseEntity<ResponseClass> result = (ResponseEntity<ResponseClass>) send(request, method).toEntity(responseClass.getClass()).block();
        if (result.getStatusCode() == HttpStatus.FORBIDDEN) {
            refreshToken();
            result = (ResponseEntity<ResponseClass>) send(request, method).toEntity(responseClass.getClass()).block();
        }
        return result.getBody();
    }

    public void getTokens(String login, String password) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("username", login);
        formData.add("password", password);
        ResponseEntity<SecurityTokens> result = this.webClient
            .post()
            .uri(this.SUMO_SERVER_LINK + this.LOGIN_ENDPOINT)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(BodyInserters.fromFormData(formData))
            .retrieve()
            .toEntity(SecurityTokens.class)
            .block();
        System.out.println(result);
    }

    private WebClient.RequestHeadersSpec<?> prepareRequestToSend(RequestEntity<?> request, HttpMethod method) {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        Map<String, String> maps = objectMapper.convertValue(request.getBody(), new TypeReference<Map<String, String>>() {});
        body.setAll(maps);

        return webClient
            .method(method)
            .uri(request.getUrl())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + securityTokenService.getSecurityTokens().getAccessToken())
            .body(BodyInserters.fromFormData(body));
    }

    public void refreshToken() {
        ResponseEntity<SecurityTokens> result = this.webClient
            .get()
            .uri(this.SUMO_SERVER_LINK + this.REFRESH_TOKEN_ENDPOINT)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + securityTokenService.getSecurityTokens().getRefreshToken())
            .retrieve()
            .toEntity(SecurityTokens.class)
            .block();
        securityTokenService.saveSecurityTokens(result.getBody());
    }
}
