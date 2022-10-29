package sumo.desktop_server.Vendors.SumoWebServer.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import sumo.desktop_server.Vendors.SumoWebServer.Conectivity.SumoServerRequestType;
import sumo.desktop_server.Vendors.VendorRequest;

import java.util.Map;


public class SumoWebServerRequest<Payload> implements VendorRequest<Payload> {
    private Payload payload;
    private Map<String, String> headers;
    @Getter
    protected SumoServerRequestType sumoServerRequestType;

    public SumoWebServerRequest(Payload payload, Map<String, String> headers) {
        this.payload = payload;
        this.headers = headers;
    }

    public SumoWebServerRequest() {
    }

    @Override
    public Payload getPayload() {
        return this.payload;
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public VendorRequest<Payload> withHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }





}
