package sumo.desktop_server.Vendors.SumoWebServer.Conectivity;

import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import sumo.desktop_server.Vendors.SumoWebServer.Schema.SumoWebServerRequest;

import javax.xml.bind.JAXBElement;

public class SumoWebServerConnector<SumoWebServerRq extends SumoWebServerRequest<?>, SumoWebServerRs> extends WebServiceGatewaySupport implements SumoServerConnectorInterface<SumoWebServerRq, SumoWebServerRs> {

    private final WebServiceTemplate webServiceTemplate;
    private final WebServiceMessageCallback requestHeadersFactory;

    public SumoWebServerConnector(WebServiceTemplate webServiceTemplate, WebServiceMessageCallback requestHeadersFactory) {
        this.webServiceTemplate = webServiceTemplate;
        this.requestHeadersFactory = requestHeadersFactory;
    }


    @Override
    public SumoWebServerRs send(SumoWebServerRq vendorRequest) {
        SumoWebServerRs response = callService(vendorRequest);
        return response;
    }

    public SumoWebServerRs callService(SumoWebServerRq sumoWebServerRq) {
        try {
            JAXBElement<SumoWebServerRs> response;
            response = (JAXBElement<SumoWebServerRs>) webServiceTemplate.marshalSendAndReceive(
                webServiceTemplate.getDefaultUri(), SumoRequestSerializer.serializeRequest(sumoWebServerRq));
            return response.getValue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


}
