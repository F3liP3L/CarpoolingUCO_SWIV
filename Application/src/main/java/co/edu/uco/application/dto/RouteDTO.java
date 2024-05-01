package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilText;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.TIME;
import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class RouteDTO {
    private UUID id;
    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private List<String> pointOfInterest;
    private List<PositionDTO> positions;
    private LocalDateTime routeTime;
    private String status;
    public RouteDTO(UUID id, DriverPerVehicleDTO driverVehicle, int routeCapacity, List<String> pointOfInterest, List<PositionDTO> positions, LocalDateTime routeTime, String status) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setPointOfInterest(pointOfInterest);
        setRouteTime(routeTime);
        setPositions(positions);
        setStatus(status);
    }

    public RouteDTO() {
        setId(getUtilUUID().getDefaultUUID(getUtilUUID().getDefaultUUID(id)));
        setDriverVehicle(DriverPerVehicleDTO.create());
        setRouteCapacity(ZERO);
        setPointOfInterest(List.of(UtilText.EMPTY));
        setRouteTime(TIME);
        setPositions(new ArrayList<>());
        setStatus(UtilText.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public DriverPerVehicleDTO getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDTO driverVehicle) {
        this.driverVehicle = getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleDTO.create());
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) getUtilNumeric().getDefault(routeCapacity);
    }

    public LocalDateTime getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(LocalDateTime routeTime) {
        this.routeTime = getUtilDate().getDefaultTimeIfNull(routeTime);
    }
    public List<String> getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(List<String> pointOfInterest) {
        this.pointOfInterest = getUtilObject().getDefaultIsNull(pointOfInterest,List.of(UtilText.EMPTY));
    }
    public List<PositionDTO> getPositions() {
        return positions;
    }
    public void setPositions(List<PositionDTO> positions) {
        this.positions = getUtilObject().getDefaultIsNull(positions, new ArrayList<>());
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = getUtilText().trim(status);
    }
}
