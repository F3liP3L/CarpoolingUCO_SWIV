package co.edu.uco.application.usecase.route;

import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.DeleteRouteUseCase;
import co.edu.uco.port.output.repository.RouteRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class DeleteRouteUseCaseImpl implements DeleteRouteUseCase {

    private final RouteRepository routeRepository;

    public DeleteRouteUseCaseImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void execute(UUID domain) {
        Optional<RouteEntity> response = routeRepository.findById(domain);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("Route not found");
        }
        routeRepository.deleteById(domain);
    }
}
