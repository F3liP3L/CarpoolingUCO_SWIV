package co.edu.uco.application.facade.route.impl;

import co.edu.uco.application.dto.requestroute.RouteAvailableDTO;
import co.edu.uco.application.facade.route.FindRouteUseCaseFacade;
import co.edu.uco.application.facade.route.ListRouteActiveUseCaseFacade;
import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.FindRouteActiveUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListRouteActiveUseCaseFacadeImpl implements ListRouteActiveUseCaseFacade {

    private final EntityAssembler entityAssembler;
    private final FindRouteActiveUseCase findRouteActiveUseCase;

    public ListRouteActiveUseCaseFacadeImpl(EntityAssembler entityAssembler, FindRouteActiveUseCase findRouteActiveUseCase) {
        this.entityAssembler = entityAssembler;
        this.findRouteActiveUseCase = findRouteActiveUseCase;
    }

    @Override
    public List<RouteAvailableDTO> execute(Optional<RouteAvailableDTO> param) {
        return findRouteActiveUseCase.execute(Optional.of(new RouteEntity())).stream().map(route -> entityAssembler.assembleDTO(route, RouteAvailableDTO.class)).toList();
    }
}
