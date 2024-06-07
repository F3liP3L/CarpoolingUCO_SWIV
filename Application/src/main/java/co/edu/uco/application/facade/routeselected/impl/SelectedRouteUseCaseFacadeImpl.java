package co.edu.uco.application.facade.routeselected.impl;

import co.edu.uco.application.dto.RouteSelectedDTO;
import co.edu.uco.application.facade.routeselected.SelectedRouteUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.port.input.bussiness.routeselected.SelectedRouteUseCase;
import org.springframework.stereotype.Component;

@Component
public class SelectedRouteUseCaseFacadeImpl implements SelectedRouteUseCaseFacade {

    private final SelectedRouteUseCase selectedRouteUseCase;
    private final DTOAssembler<RouteSelectedDTO, RouteSelectedEntity> dtoAssembler;

    public SelectedRouteUseCaseFacadeImpl(SelectedRouteUseCase selectedRouteUseCase, DTOAssembler<RouteSelectedDTO, RouteSelectedEntity> dtoAssembler) {
        this.selectedRouteUseCase = selectedRouteUseCase;
        this.dtoAssembler = dtoAssembler;
    }

    @Override
    public void execute(RouteSelectedDTO domain) {
        selectedRouteUseCase.execute(dtoAssembler.assembleDomain(domain));
    }
}
