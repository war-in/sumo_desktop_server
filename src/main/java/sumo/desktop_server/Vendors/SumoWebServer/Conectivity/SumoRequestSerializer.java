package sumo.desktop_server.Vendors.SumoWebServer.Conectivity;

import sumo.desktop_server.Vendors.SumoWebServer.Schema.Security.SumoServerTokensRequest;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class SumoRequestSerializer {
    //    narazie przejściowe
    private static final QName QNAME = new QName("http://www.sumoserver.com", "sumoServer");

    public static JAXBElement<?> serializeRequest(SumoWebServerRequest<?> sumoWebServerRequest) {
        JAXBElement<?> result = null;
        switch (sumoWebServerRequest.getSumoServerRequestType()) {
            case GET_SECURITY_TOKENS -> {
                result = new JAXBElement(QNAME, SumoServerTokensRequest.class, sumoWebServerRequest.getPayload());
            }
        }
        return result;
    }

}
