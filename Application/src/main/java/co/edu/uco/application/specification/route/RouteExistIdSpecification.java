package co.edu.uco.application.specification.route;


import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.port.output.repository.RouteRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class RouteExistIdSpecification extends CompositeSpecification<RouteEntity> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public boolean isSatisfyBy(RouteEntity object) {
        return isExist(object);
    }

    private boolean isExist(RouteEntity route) {
        try {
            Optional<RouteEntity> routeResponse = routeRepository.findById(route.getId());
            if (routeResponse.isPresent()) {
                throw CarpoolingCustomException.buildUserException("A route with the sent identifier already exists.!!");
            }
            return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (Exception exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred while trying to obtain route information.", exception.getMessage() , exception);
        }

    }
}
