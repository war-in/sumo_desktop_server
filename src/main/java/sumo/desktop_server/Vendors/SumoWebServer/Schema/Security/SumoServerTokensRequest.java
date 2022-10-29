package sumo.desktop_server.Vendors.SumoWebServer.Schema.Security;

import lombok.NoArgsConstructor;
import sumo.desktop_server.Vendors.SumoWebServer.Conectivity.SumoServerRequestType;
import sumo.desktop_server.Vendors.SumoWebServer.Schema.SumoWebServerRequest;

import java.util.Map;


public class SumoServerTokensRequest extends SumoWebServerRequest<SumoServerCredentials> {


    public SumoServerTokensRequest(SumoServerCredentials sumoServerCredentials, Map<String, String> headers) {
        super(sumoServerCredentials, headers);
        this.sumoServerRequestType = SumoServerRequestType.GET_SECURITY_TOKENS;
    }

    public SumoServerTokensRequest(){
        super();
    }


}
