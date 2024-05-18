package co.edu.uco.application.usecase.route;

import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.FindRouteUseCase;
import co.edu.uco.port.output.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindRouteUseCaseImpl implements FindRouteUseCase {

    private final RouteRepository routeRepository;

    public FindRouteUseCaseImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteEntity execute(UUID id) {
        return new RouteEntity();
    }
}
