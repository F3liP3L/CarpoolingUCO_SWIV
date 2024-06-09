package co.edu.uco.application.facade.routeselected.impl;

import co.edu.uco.application.dto.RouteSelectedDTO;
import co.edu.uco.application.facade.routeselected.ListRouteSelectedUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.port.input.bussiness.routeselected.ListRouteSelectedUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListRouteSelectedUseCaseFacadeImpl implements ListRouteSelectedUseCaseFacade {

    private final DTOAssembler<RouteSelectedDTO, RouteSelectedEntity> dtoAssembler;
    private final ListRouteSelectedUseCase listRouteSelectedUseCase;

    public ListRouteSelectedUseCaseFacadeImpl(DTOAssembler<RouteSelectedDTO, RouteSelectedEntity> dtoAssembler, ListRouteSelectedUseCase listRouteSelectedUseCase) {
        this.dtoAssembler = dtoAssembler;
        this.listRouteSelectedUseCase = listRouteSelectedUseCase;
    }

    @Override
    public List<RouteSelectedDTO> execute(Optional<RouteSelectedDTO> param) {
        Optional<RouteSelectedEntity> filter = Optional.of(RouteSelectedEntity.build(param.get().getRouteAvailable().getId()));
        return listRouteSelectedUseCase.execute(filter).stream().map(dtoAssembler::assembleDTO).toList();
    }
}
