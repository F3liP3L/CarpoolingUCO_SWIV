package co.edu.uco.application.usecase.routeselected;

import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.port.input.bussiness.routeselected.FindRouteSelectedUseCase;
import co.edu.uco.port.output.repository.RouteSelectedRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindRouteSelectedUseCaseImpl implements FindRouteSelectedUseCase {

    private final RouteSelectedRepository routeSelectedRepository;

    public FindRouteSelectedUseCaseImpl(RouteSelectedRepository routeSelectedRepository) {
        this.routeSelectedRepository = routeSelectedRepository;
    }

    @Override
    public RouteSelectedEntity execute(UUID param) {
        Optional<RouteSelectedEntity> response = routeSelectedRepository.findById(param);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("Route Selected not found");
        }
        return response.get();
    }
}
