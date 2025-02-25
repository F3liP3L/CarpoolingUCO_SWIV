package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilDate;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;

public class RouteTrackEntity {
    private UUID id;
    private RouteEntity route;
    private LocalDateTime routeTrackTime;
    private int latitude;
    private int longitude;
    private LocalDateTime routeCreationTime;

    public RouteTrackEntity(UUID id, RouteEntity route, LocalDateTime routeTrackTime, int latitude, int longitude, LocalDateTime routeCreationTime) {
        setId(id);
        setRoute(route);
        setRouteTrackTime(routeTrackTime);
        setLatitude(latitude);
        setLongitude(longitude);
        setRouteCreationTime(routeCreationTime);
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
        this.route = route;
    }

    public LocalDateTime getRouteTrackTime() {
        return routeTrackTime;
    }

    public void setRouteTrackTime(final LocalDateTime routeTrackTime) {
        this.routeTrackTime = UtilDate.getDefaultTimeIfNull(routeTrackTime);
    }

    public int getLatitude() { return latitude; }

    public void setLatitude(int latitude) {
        this.latitude = UtilNumeric
                .isLessThan(latitude , ZERO) ? ZERO : latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = UtilNumeric
                .isLessThan(longitude , ZERO) ? ZERO : longitude;
    }

    public LocalDateTime getRouteCreationTime() { return routeCreationTime; }
    public void setRouteCreationTime(final LocalDateTime routeCreationTime) {
        this.routeCreationTime = UtilDate.getDefaultTimeIfNull(routeCreationTime);
    }

}