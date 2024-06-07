package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class RouteSelectedEntity {

    private UUID id;
    private RouteEntity route;
    private CustomerEntity customer;

    public RouteSelectedEntity(UUID id, RouteEntity route, CustomerEntity customer) {
        setId(id);
        setRoute(route);
        setCustomer(customer);
    }

    public RouteSelectedEntity() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setCustomer(CustomerEntity.build());
        setRoute(RouteEntity.build());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = getUtilObject().getDefaultIsNull(route, RouteEntity.build());
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = getUtilObject().getDefaultIsNull(customer, CustomerEntity.build());
    }
}
