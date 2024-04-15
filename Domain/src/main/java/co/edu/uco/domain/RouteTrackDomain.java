package co.edu.uco.domain;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;


public class RouteTrackDomain {
    private UUID id;
    private RouteDTO route;
    private LocalDateTime routeTrackTime;
    private int latitude;
    private int longitude;
    private LocalDateTime routeCreationTime;

    public RouteTrackDomain(UUID id, RouteDTO route, LocalDateTime routeTrackTime, int latitude, int longitude, LocalDateTime routeCreationTime) {
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
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }

    public LocalDateTime getRouteTrackTime() {
        return routeTrackTime;
    }

    public void setRouteTrackTime(final LocalDateTime routeTrackTime) {
        this.routeTrackTime = getUtilDate().getDefaultTimeIfNull(routeTrackTime);
    }

    public int getLatitude() { return latitude; }

    public void setLatitude(int latitude) {
        this.latitude = UtilNumeric.getUtilNumeric()
                .isLessThan(latitude , ZERO) ? ZERO : latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = UtilNumeric.getUtilNumeric()
                .isLessThan(longitude , ZERO) ? ZERO : longitude;
    }

    public LocalDateTime getRouteCreationTime() { return routeCreationTime; }
    public void setRouteCreationTime(final LocalDateTime routeCreationTime) {
        this.routeCreationTime = getUtilDate().getDefaultTimeIfNull(routeCreationTime);
    }

}