package co.edu.uco.application.usecase.route;

import co.edu.uco.application.specification.impl.route.ValidRouteSpecification;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.input.bussiness.route.RegisterRouteUseCase;
import co.edu.uco.port.output.repository.RouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RegisterRouteUseCaseImpl implements RegisterRouteUseCase {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private ValidRouteSpecification validRouteSpecification;

    @Override
    public void execute(RouteEntity domain) {
        validRouteSpecification.isSatisfyBy(domain);
        routeRepository.save(domain);
    }
}
