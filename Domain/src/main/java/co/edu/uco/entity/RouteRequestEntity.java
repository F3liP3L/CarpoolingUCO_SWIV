package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

/**
 * @author Juan Felipe Cardona;
 * Email: felipe7u7432@gmail.com
 * @version id: <b>CarpoolingUCO_SWIV/b> 16/4/2024, 23:19
 **/
public class RouteRequestEntity {
    private UUID id;
    private RouteRequestDriverVehicleEntity driverVehicle;
    private PositionEntity origin;
    private PositionEntity destination;
    private int routeCapacity;

    public RouteRequestEntity() {
        setId(getUtilUUID().getDefaultUUID(getUtilUUID().getDefaultUUID(id)));
        setDriverVehicle(RouteRequestDriverVehicleEntity.build());
        setOrigin(PositionEntity.build());
        setDestination(PositionEntity.build());
        setRouteCapacity(ZERO);
    }

    public RouteRequestEntity(UUID id, RouteRequestDriverVehicleEntity driverVehicle, PositionEntity origin, PositionEntity destination, int routeCapacity) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setOrigin(origin);
        setDestination(destination);
        setRouteCapacity(routeCapacity);
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }
    public RouteRequestDriverVehicleEntity getDriverVehicle() {
        return driverVehicle;
    }
    public void setDriverVehicle(RouteRequestDriverVehicleEntity driverVehicle) {
        this.driverVehicle = getUtilObject().getDefaultIsNull(driverVehicle, RouteRequestDriverVehicleEntity.build());
    }

    public PositionEntity getOrigin() {
        return origin;
    }

    public void setOrigin(PositionEntity origin) {
        this.origin = getUtilObject().getDefaultIsNull(origin, PositionEntity.build());
    }

    public PositionEntity getDestination() {
        return destination;
    }

    public void setDestination(PositionEntity destination) {
        this.destination = getUtilObject().getDefaultIsNull(destination, PositionEntity.build());
    }
    public int getRouteCapacity() {
        return routeCapacity;
    }
    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) getUtilNumeric().getDefault(routeCapacity);
    }
}
