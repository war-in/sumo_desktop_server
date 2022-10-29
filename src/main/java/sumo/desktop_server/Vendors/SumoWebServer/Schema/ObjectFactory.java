package sumo.desktop_server.Vendors.SumoWebServer.Schema;

import sumo.desktop_server.Vendors.SumoWebServer.Schema.Security.SumoServerTokensRequest;
import sumo.desktop_server.Vendors.SumoWebServer.Schema.Security.SumoServerTokensResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

public class ObjectFactory {

    //    narazie przejściowe
    private static final QName QNAME = new QName("http://www.sumoserver.com", "sumoServer");

    public ObjectFactory() {
    }

    public SumoServerTokensRequest createSumoServerTokensRequest(){
        return new SumoServerTokensRequest();
    }

    public SumoServerTokensResponse createSumoServerTokensResponse(){
        return new SumoServerTokensResponse();
    }

    @XmlElementDecl(
        namespace = "http://www.sumoserver.com",
        name = "SumoServerTokensRequest"
    )
    public JAXBElement<SumoServerTokensRequest> createSumoServerTokensRequest(SumoServerTokensRequest value) {
        return new JAXBElement(QNAME, SumoServerTokensRequest.class, null, value);
    }

    @XmlElementDecl(
        namespace = "http://www.sumoserver.com",
        name = "SumoServerTokensResponse"
    )
    public JAXBElement<SumoServerTokensResponse> createSumoServerTokensResponse(SumoServerTokensResponse value) {
        return new JAXBElement(QNAME, SumoServerTokensResponse.class, null, value);
    }
}
