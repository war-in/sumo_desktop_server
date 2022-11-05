package sumo.desktop_server.Vendors.SumoWebServer.Schema.Security;

import org.springframework.http.HttpMethod;
import sumo.desktop_server.Vendors.SumoWebServer.Conectivity.SumoServerRequestType;

import java.util.Map;


public class SumoServerTokensRequest extends SumoWebServerRequest<SumoServerCredentials> {


    public SumoServerTokensRequest(SumoServerCredentials sumoServerCredentials, Map<String, String> headers) {
        super(sumoServerCredentials, headers);
        this.sumoServerRequestType = SumoServerRequestType.GET_SECURITY_TOKENS;
        this.httpMethod = HttpMethod.GET;
    }

    public SumoServerTokensRequest(){
        super();
    }


}
