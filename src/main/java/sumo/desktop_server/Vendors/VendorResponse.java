package sumo.desktop_server.Vendors;

import java.util.List;

public interface VendorResponse<Payload, VendorWarning> {

    Payload getPayload();

    List<VendorWarning> getWarnings();
}
