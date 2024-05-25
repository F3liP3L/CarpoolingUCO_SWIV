package co.edu.uco.application.usecase.route;

import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.FindRouteActiveUseCase;
import co.edu.uco.port.output.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ListRouteActiveUseCaseImpl implements FindRouteActiveUseCase {

    private final RouteRepository routeRepository;

    public ListRouteActiveUseCaseImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<RouteEntity> execute(Optional<RouteEntity> param) {
        return routeRepository.findRouteActive();
    }
}
