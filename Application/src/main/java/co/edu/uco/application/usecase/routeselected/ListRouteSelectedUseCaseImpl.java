package co.edu.uco.application.usecase.routeselected;

import co.edu.uco.application.dto.requestroute.RouteIdVO;
import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.port.input.bussiness.routeselected.ListRouteSelectedUseCase;
import co.edu.uco.port.output.repository.RouteSelectedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListRouteSelectedUseCaseImpl implements ListRouteSelectedUseCase {

    private final RouteSelectedRepository routeSelectedRepository;

    public ListRouteSelectedUseCaseImpl(RouteSelectedRepository routeSelectedRepository) {
        this.routeSelectedRepository = routeSelectedRepository;
    }

    @Override
    public List<RouteSelectedEntity> execute(Optional<RouteSelectedEntity> param) {
        return List.of();
    }
}
