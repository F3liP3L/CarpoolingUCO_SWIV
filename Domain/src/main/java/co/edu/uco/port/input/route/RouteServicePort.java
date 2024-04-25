package co.edu.uco.port.input.route;

import co.edu.uco.entity.PositionEntity;
import co.edu.uco.entity.RouteEntity;

public interface RouteServicePort {
    RouteEntity buildRoute(PositionEntity origin, PositionEntity destination);
}
