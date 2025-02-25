package co.edu.uco.application.dto.requestroute;

import co.edu.uco.application.dto.PositionDTO;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.*;
import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilUUID.*;

public class RouteRequestDTO {
    private UUID id;
    private RouteRequestDriverVehicleDTO driverVehicle;
    private PositionDTO origin;
    private PositionDTO destination;
    private int routeCapacity;

    public RouteRequestDTO() {
        setId(getNewUUID());
        setDriverVehicle(RouteRequestDriverVehicleDTO.create());
        setOrigin(PositionDTO.build());
        setDestination(PositionDTO.build());
        setRouteCapacity(ZERO);
    }

    public RouteRequestDTO(UUID id, RouteRequestDriverVehicleDTO driverVehicle, PositionDTO origin, PositionDTO destination, int routeCapacity) {
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
        this.id = getDefaultUUID(id);
    }
    public RouteRequestDriverVehicleDTO getDriverVehicle() {
        return driverVehicle;
    }
    public void setDriverVehicle(RouteRequestDriverVehicleDTO driverVehicle) {
        this.driverVehicle = getDefaultIsNull(driverVehicle, RouteRequestDriverVehicleDTO.create());
    }

    public PositionDTO getOrigin() {
        return origin;
    }

    public void setOrigin(PositionDTO origin) {
        this.origin = getDefaultIsNull(origin, PositionDTO.build());
    }

    public PositionDTO getDestination() {
        return destination;
    }

    public void setDestination(PositionDTO destination) {
        this.destination = getDefaultIsNull(destination, PositionDTO.build());
    }
    public int getRouteCapacity() {
        return routeCapacity;
    }
    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) getDefault(routeCapacity);
    }
}
