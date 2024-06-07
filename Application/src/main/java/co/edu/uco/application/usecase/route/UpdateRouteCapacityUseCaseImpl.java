package co.edu.uco.application.usecase.route;

import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.UpdateRouteCapacityUseCase;
import co.edu.uco.port.output.repository.RouteRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;

@Service
public class UpdateRouteCapacityUseCaseImpl implements UpdateRouteCapacityUseCase {

    private final RouteRepository repository;

    public UpdateRouteCapacityUseCaseImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(RouteEntity domain) {
        RouteEntity existingRoute = repository.findById(domain.getId())
                .orElseThrow(() -> CarpoolingCustomException.buildUserException("Route not found"));

        if (existingRoute.getRouteCapacity() == 0) {
            throw CarpoolingCustomException.buildUserException("The capacity must be greater than or equal to zero.");
        }
        existingRoute.setRouteCapacity(domain.getRouteCapacity());

        repository.save(existingRoute);
    }
}
