package co.edu.uco.application.facade.routeselected.impl;

import co.edu.uco.application.dto.RouteSelectedDTO;
import co.edu.uco.application.facade.routeselected.FindRouteSelectedUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.port.input.bussiness.routeselected.FindRouteSelectedUseCase;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FindRouteSelectedUseCaseFacadeImpl implements FindRouteSelectedUseCaseFacade {

    private final FindRouteSelectedUseCase findRouteSelectedUseCase;
    private final DTOAssembler<RouteSelectedDTO, RouteSelectedEntity> dtoAssembler;

    public FindRouteSelectedUseCaseFacadeImpl(FindRouteSelectedUseCase findRouteSelectedUseCase, DTOAssembler<RouteSelectedDTO, RouteSelectedEntity> dtoAssembler) {
        this.findRouteSelectedUseCase = findRouteSelectedUseCase;
        this.dtoAssembler = dtoAssembler;
    }

    @Override
    public RouteSelectedDTO execute(UUID param) {
        return dtoAssembler.assembleDTO(findRouteSelectedUseCase.execute(param));
    }




}
