package co.edu.uco.application.dto.requestroute;

import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.dto.PositionDTO;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class RouteAvailableDTO {
    private UUID id;
    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private PositionDTO origin;
    private PositionDTO destination;

    public RouteAvailableDTO(UUID id, DriverPerVehicleDTO driverVehicle, PositionDTO origin, PositionDTO destination, int routeCapacity) {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setOrigin(origin);
        setDestination(destination);
    }

    public RouteAvailableDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setRouteCapacity(UtilNumeric.ZERO);
        setDriverVehicle(DriverPerVehicleDTO.build());
        setOrigin(PositionDTO.build());
        setDestination(PositionDTO.build());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public DriverPerVehicleDTO getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDTO driverVehicle) {
        this.driverVehicle = UtilObject.getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleDTO.build());
    }
    public PositionDTO getOrigin() {
        return origin;
    }

    public void setOrigin(PositionDTO origin) {
        this.origin = UtilObject.getUtilObject().getDefaultIsNull(origin, PositionDTO.build());
    }

    public PositionDTO getDestination() {
        return destination;
    }

    public void setDestination(PositionDTO destination) {
        this.destination = UtilObject.getUtilObject().getDefaultIsNull(destination, PositionDTO.build());
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) UtilNumeric.getUtilNumeric().getDefault(routeCapacity);
    }

    public static RouteAvailableDTO build(){
        return new RouteAvailableDTO();
    }
}
