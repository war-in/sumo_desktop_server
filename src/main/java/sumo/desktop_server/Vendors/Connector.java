package sumo.desktop_server.Vendors;

public interface Connector<VendorRequestPayload, VendorResponsePayload> {

    VendorResponsePayload send(
        VendorRequestPayload vendorRequestPayload);
}
