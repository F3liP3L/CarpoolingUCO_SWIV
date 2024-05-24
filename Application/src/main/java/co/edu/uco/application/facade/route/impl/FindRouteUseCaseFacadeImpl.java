package co.edu.uco.application.facade.route.impl;

import co.edu.uco.application.dto.RouteDTO;
import co.edu.uco.application.facade.route.FindRouteUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.FindRouteUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindRouteUseCaseFacadeImpl implements FindRouteUseCaseFacade {

    private final FindRouteUseCase findRouteUseCase;
    private final DTOAssembler<RouteDTO, RouteEntity> dtoAssembler;

    public FindRouteUseCaseFacadeImpl(FindRouteUseCase findRouteUseCase, DTOAssembler<RouteDTO, RouteEntity> dtoAssembler) {
        this.findRouteUseCase = findRouteUseCase;
        this.dtoAssembler = dtoAssembler;
    }

    @Override
    public RouteDTO execute(UUID param) {
        return dtoAssembler.assembleDTO(findRouteUseCase.execute(param));
    }
}
