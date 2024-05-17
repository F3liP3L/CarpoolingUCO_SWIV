package co.edu.uco.port.input.bussiness.route;

import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.FindUseCase;

import java.util.UUID;

public interface FindRouteUseCase extends FindUseCase<RouteEntity, UUID> {
}
