package co.edu.uco.application.specification.impl.route;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.RouteRequestEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

@Component
public class RouteRequestNotInvalidSpecification extends CompositeSpecification<RouteRequestEntity> {
    @Override
    public boolean isSatisfyBy(RouteRequestEntity object) {
        return isValid(object);
    }

    private boolean isValid(RouteRequestEntity route) {
        if (route.getOrigin().getLatitude().concat(route.getOrigin().getLongitude())
                .equals(route.getDestination().getLatitude().concat(route.getDestination().getLongitude()))) {
            throw CarpoolingCustomException.buildUserException("The initial position and destination position of the route are the same.");
        }
        return true;
    }
}
