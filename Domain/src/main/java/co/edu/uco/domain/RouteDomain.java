package co.edu.uco.domain;

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

public class RouteDomain {
    private UUID id;
    private DriverPerVehicleDomain driverVehicle;
    private int routeCapacity;
    private PositionDomain origin;
    private PositionDomain destination;
    private List<PositionDomain> positions;
    private List<String> pointOfInterest;
    private LocalDateTime routeTime;
    private StatusDomain routeStatus;

    public RouteDomain(UUID id, DriverPerVehicleDomain driverVehicle, int routeCapacity, List<String> pointOfInterest, List<PositionDomain> positions, PositionDomain origin, PositionDomain destination, LocalDateTime routeTime, StatusDomain routeStatus) {
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

    public RouteDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setRouteCapacity(ZERO);
        setPositions(new ArrayList<>());
        setPointOfInterest(new ArrayList<>());
        setRouteStatus(StatusDomain.build());
        setDriverVehicle(DriverPerVehicleDomain.build());
        setRouteTime(TIME);
        setDestination(PositionDomain.build());
        setOrigin(PositionDomain.build());
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

    public DriverPerVehicleDomain getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDomain driverVehicle) {
        this.driverVehicle = getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleDomain.build());
    }

    public StatusDomain getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(StatusDomain routeStatus) {
        this.routeStatus = getUtilObject().getDefaultIsNull(routeStatus, StatusDomain.build());
    }

    public List<PositionDomain> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDomain> positions) {
        this.positions = UtilObject.getUtilObject().getDefaultIsNull(positions, new ArrayList<>());
    }
    public PositionDomain getOrigin() {
        return origin;
    }
    public void setOrigin(PositionDomain origin) {
        this.origin = UtilObject.getUtilObject().getDefaultIsNull(origin, PositionDomain.build());
    }
    public PositionDomain getDestination() {
        return destination;
    }

    public void setDestination(PositionDomain destination) {
        this.destination = UtilObject.getUtilObject().getDefaultIsNull(destination, PositionDomain.build());
    }

    public static RouteDomain build() {
        return new RouteDomain();
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
