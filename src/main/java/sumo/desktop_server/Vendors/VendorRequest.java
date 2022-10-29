package sumo.desktop_server.Vendors;

import java.util.Map;

public interface VendorRequest<Payload>{
    Payload getPayload();

    Map<String, String> getHeaders();

    VendorRequest<Payload> withHeaders(Map<String, String> headers);
}
