package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.TIME;
import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class RouteEntity {
    private UUID id;
    private DriverPerVehicleEntity driverVehicle;
    private int routeCapacity;
    private PositionEntity origin;
    private PositionEntity destination;
    private List<PositionEntity> positions;
    private List<String> pointOfInterest;
    private LocalDateTime routeTime;
    private StatusEntity routeStatus;

    public RouteEntity(UUID id, DriverPerVehicleEntity driverVehicle, int routeCapacity, List<String> pointOfInterest, List<PositionEntity> positions, PositionEntity origin, PositionEntity destination, LocalDateTime routeTime, StatusEntity routeStatus) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setRouteStatus(routeStatus);
        setPointOfInterest(pointOfInterest);
        setRouteTime(routeTime);
        setPositions(positions);
        setOrigin(origin);
        setDestination(destination);
    }

    public RouteEntity() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setRouteCapacity(ZERO);
        setPositions(new ArrayList<>());
        setPointOfInterest(new ArrayList<>());
        setRouteStatus(StatusEntity.build());
        setDriverVehicle(DriverPerVehicleEntity.build());
        setRouteTime(TIME);
        setDestination(PositionEntity.build());
        setOrigin(PositionEntity.build());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public final void setRouteCapacity(final int capacity) {
        this.routeCapacity = getUtilNumeric()
                .isLessThan(capacity, ZERO) ? ZERO: capacity;
    }

    public List<String> getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(List<String> pointOfInterest) {
        this.pointOfInterest = UtilObject.getUtilObject().getDefaultIsNull(pointOfInterest, new ArrayList<>());
    }

    public LocalDateTime getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(LocalDateTime routeTime) {
        this.routeTime = getUtilDate().getDefaultTimeIfNull(routeTime);
    }

    public DriverPerVehicleEntity getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleEntity driverVehicle) {
        this.driverVehicle = getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleEntity.build());
    }

    public StatusEntity getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(StatusEntity routeStatus) {
        this.routeStatus = getUtilObject().getDefaultIsNull(routeStatus, StatusEntity.build());
    }

    public List<PositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionEntity> positions) {
        this.positions = UtilObject.getUtilObject().getDefaultIsNull(positions, new ArrayList<>());
    }
    public PositionEntity getOrigin() {
        return origin;
    }
    public void setOrigin(PositionEntity origin) {
        this.origin = UtilObject.getUtilObject().getDefaultIsNull(origin, PositionEntity.build());
    }
    public PositionEntity getDestination() {
        return destination;
    }

    public void setDestination(PositionEntity destination) {
        this.destination = UtilObject.getUtilObject().getDefaultIsNull(destination, PositionEntity.build());
    }

    public static RouteEntity build() {
        return new RouteEntity();
    }

    @Override
    public String toString() {
        return "RouteDomain{" +
                "id=" + id +
                ", driverVehicle=" + driverVehicle +
                ", routeCapacity=" + routeCapacity +
                ", origin=" + origin +
                ", destination=" + destination +
                ", positions=" + positions +
                ", pointOfInterest=" + pointOfInterest +
                ", routeTime=" + routeTime +
                ", routeStatus=" + routeStatus +
                '}';
    }
}
