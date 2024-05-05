package co.edu.uco.application.specification.route;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.RouteRequestEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

@Component
public class ValidateNotDefaultRouteRequestSpecification extends CompositeSpecification<RouteRequestEntity> {
    @Override
    public boolean isSatisfyBy(RouteRequestEntity object) {
        return isValid(object);
    }
    private boolean isValid(RouteRequestEntity object) {
        if (object.getOrigin().getLatitude().isEmpty() || object.getOrigin().getLongitude().isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The initial position of the route has to be entered.");
        }
        if (object.getDestination().getLatitude().isEmpty() || object.getDestination().getLongitude().isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The destination position of the route has to be entered.");
        }
        return true;
    }

}
