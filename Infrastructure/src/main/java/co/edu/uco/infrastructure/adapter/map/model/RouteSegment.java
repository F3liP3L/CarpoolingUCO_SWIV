package co.edu.uco.infrastructure.adapter.map.model;

import com.google.maps.model.LatLng;

import java.util.List;

public class RouteSegment {
    private final List<LatLng> coordinates;
    public RouteSegment(List<LatLng> coordinates) {
        this.coordinates = coordinates;
    }
    public LatLng getMidPoint() {
        int middleIndex = coordinates.size() / 2;
        return coordinates.get(middleIndex);
    }
}
