package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

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
        setId(UtilUUID.getNewUUID());
        setCustomer(CustomerEntity.build());
        setRoute(RouteEntity.build());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = UtilObject.getDefaultIsNull(route, RouteEntity.build());
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = UtilObject.getDefaultIsNull(customer, CustomerEntity.build());
    }

    public static RouteSelectedEntity build() {
        return new RouteSelectedEntity();
    }

    public static RouteSelectedEntity build(UUID id) {
        return new RouteSelectedEntity(id, RouteEntity.build(), CustomerEntity.build());
    }
}
