package co.edu.uco.application.dto;

import co.edu.uco.application.dto.requestroute.RouteIdVO;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class RouteSelectedDTO {
    private UUID id;
    private RouteIdVO routeAvailable;
    private CustomerDTO customer;

    public RouteSelectedDTO(UUID id, RouteIdVO routeAvailable, CustomerDTO customer) {
        setId(id);
        setRouteAvailable(routeAvailable);
        setCustomer(customer);
    }

    public RouteSelectedDTO() {
        setId(getUtilUUID().getDefaultUUID(getUtilUUID().getDefaultUUID(id)));
        setRouteAvailable(RouteIdVO.build());
        setCustomer(CustomerDTO.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public RouteIdVO getRouteAvailable() {
        return routeAvailable;
    }

    public void setRouteAvailable(RouteIdVO routeAvailable) {
        this.routeAvailable = getUtilObject().getDefaultIsNull(routeAvailable, RouteIdVO.build());
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = getUtilObject().getDefaultIsNull(customer, CustomerDTO.create());
    }
}
