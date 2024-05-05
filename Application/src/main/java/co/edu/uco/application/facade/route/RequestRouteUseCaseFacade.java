package co.edu.uco.application.facade.route;

import co.edu.uco.application.dto.RouteDTO;
import co.edu.uco.application.dto.requestroute.RouteRequestDTO;

public interface RequestRouteUseCaseFacade {
    RouteDTO execute(RouteRequestDTO request);
}
