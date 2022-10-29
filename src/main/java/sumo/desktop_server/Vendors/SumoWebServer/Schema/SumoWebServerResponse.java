package sumo.desktop_server.Vendors.SumoWebServer.Schema;

import lombok.AllArgsConstructor;
import sumo.desktop_server.Vendors.VendorResponse;

import java.util.List;

@AllArgsConstructor
public class SumoWebServerResponse<Payload, VendorWarnings> implements VendorResponse<Payload, VendorWarnings> {
    @Override
    public Payload getPayload() {
        return null;
    }

    @Override
    public List<VendorWarnings> getWarnings() {
        return null;
    }
}
