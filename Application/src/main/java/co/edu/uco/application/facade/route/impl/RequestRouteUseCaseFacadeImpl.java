package co.edu.uco.application.facade.route.impl;

import co.edu.uco.application.dto.RouteDTO;
import co.edu.uco.application.dto.requestroute.RouteRequestDTO;
import co.edu.uco.application.facade.route.RequestRouteUseCaseFacade;
import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.RouteRequestEntity;
import co.edu.uco.port.input.bussiness.route.RequestRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestRouteUseCaseFacadeImpl implements RequestRouteUseCaseFacade {

    private final RequestRouteUseCase requestRouteUseCase;
    private final EntityAssembler entityAssembler;

    public RequestRouteUseCaseFacadeImpl(RequestRouteUseCase requestRouteUseCase, EntityAssembler entityAssembler) {
        this.requestRouteUseCase = requestRouteUseCase;
        this.entityAssembler = entityAssembler;
    }

    @Override
    public RouteDTO execute(RouteRequestDTO request) {
        RouteRequestEntity entity = entityAssembler.assembleEntity(request, RouteRequestEntity.class);
        return entityAssembler.assembleDomain(requestRouteUseCase.execute(entity), RouteDTO.class);
    }
}
