package co.edu.uco.application.dto.requestroute;

import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.dto.PositionDTO;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.getDefault;
import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class RouteAvailableDTO {
    private UUID id;
    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private PositionDTO origin;
    private PositionDTO destination;

    public RouteAvailableDTO(UUID id, DriverPerVehicleDTO driverVehicle, PositionDTO origin, PositionDTO destination, int routeCapacity) {
        setId(getDefaultUUID(id));
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setOrigin(origin);
        setDestination(destination);
    }

    public RouteAvailableDTO() {
        setId(UtilUUID.getNewUUID());
        setRouteCapacity(UtilNumeric.ZERO);
        setDriverVehicle(DriverPerVehicleDTO.build());
        setOrigin(PositionDTO.build());
        setDestination(PositionDTO.build());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public DriverPerVehicleDTO getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDTO driverVehicle) {
        this.driverVehicle = getDefaultIsNull(driverVehicle, DriverPerVehicleDTO.build());
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

    public static RouteAvailableDTO build(){
        return new RouteAvailableDTO();
    }
}
