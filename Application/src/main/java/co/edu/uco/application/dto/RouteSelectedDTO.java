package co.edu.uco.application.dto;

import co.edu.uco.application.dto.requestroute.RouteIdDTO;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class RouteSelectedDTO {
    private UUID id;
    private RouteIdDTO routeAvailable;
    private CustomerDTO customer;

    public RouteSelectedDTO(UUID id, RouteIdDTO routeAvailable, CustomerDTO customer) {
        setId(id);
        setRouteAvailable(routeAvailable);
        setCustomer(customer);
    }

    public RouteSelectedDTO() {
        setId(UtilUUID.getNewUUID());
        setRouteAvailable(RouteIdDTO.build());
        setCustomer(CustomerDTO.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public RouteIdDTO getRouteAvailable() {
        return routeAvailable;
    }

    public void setRouteAvailable(RouteIdDTO routeAvailable) {
        this.routeAvailable = getDefaultIsNull(routeAvailable, RouteIdDTO.build());
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = getDefaultIsNull(customer, CustomerDTO.create());
    }
}
