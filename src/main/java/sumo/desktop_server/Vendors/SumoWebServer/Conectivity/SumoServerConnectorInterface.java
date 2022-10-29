package sumo.desktop_server.Vendors.SumoWebServer.Conectivity;

import org.springframework.ws.client.core.WebServiceTemplate;
import sumo.desktop_server.Vendors.Connector;

public interface SumoServerConnectorInterface<SumoWebServerRq,SumoWebServerRs> extends Connector<SumoWebServerRq,SumoWebServerRs> {

    SumoWebServerRs send(SumoWebServerRq request);

    WebServiceTemplate getWebServiceTemplate();

    void setWebServiceTemplate(WebServiceTemplate webServiceTemplate);
}
