package co.edu.uco.application.usecase.routeselected;

import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.port.input.bussiness.routeselected.CancelRouteSelectedUseCase;
import co.edu.uco.port.output.repository.RouteSelectedRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CancelRouteSelectedUseCaseImpl implements CancelRouteSelectedUseCase {

    private final RouteSelectedRepository repository;

    public CancelRouteSelectedUseCaseImpl(RouteSelectedRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(UUID param) {
        Optional<RouteSelectedEntity> response = repository.findByRouteId(param);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("Route Selected not found");
        }
        repository.deleteById(response.get().getId());
    }
}
