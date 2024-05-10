package co.edu.uco.application.facade.route.impl;

import co.edu.uco.application.dto.RouteDTO;
import co.edu.uco.application.facade.route.RegisterRouteUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.RegisterRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterRouteUseCaseFacadeImpl implements RegisterRouteUseCaseFacade {

    @Autowired
    private DTOAssembler<RouteDTO, RouteEntity> dtoAssembler;

    @Autowired
    private RegisterRouteUseCase registerRouteUseCase;

    @Override
    public void execute(RouteDTO dto) {
        RouteEntity route = dtoAssembler.assembleDomain(dto);
        registerRouteUseCase.execute(route);
    }
}
