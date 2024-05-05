package co.edu.uco.port.input.bussiness.route;

import co.edu.uco.entity.RouteEntity;
import co.edu.uco.entity.RouteRequestEntity;

public interface RequestRouteUseCase {
    RouteEntity execute(RouteRequestEntity request);
}
