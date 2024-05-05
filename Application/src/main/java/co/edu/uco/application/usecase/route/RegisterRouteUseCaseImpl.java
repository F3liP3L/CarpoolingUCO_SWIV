package co.edu.uco.application.usecase.route;

import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.RegisterRouteUseCase;
import co.edu.uco.port.output.repository.RouteRepository;
import org.springframework.stereotype.Service;


@Service
public class RegisterRouteUseCaseImpl implements RegisterRouteUseCase {

    private final RouteRepository routeRepository;

    public RegisterRouteUseCaseImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void execute(RouteEntity domain) {
        routeRepository.save(domain);
    }
}
