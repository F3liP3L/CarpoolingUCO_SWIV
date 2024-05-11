package co.edu.uco.application.specification.impl.route;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.RouteRequestEntity;
import co.edu.uco.util.constants.ConstantsCarpooling;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.util.constants.ConstantsCarpooling.ONLY_ANY_NUMBER;

@Component
public class RouteRequestNotDefaultSpecification extends CompositeSpecification<RouteRequestEntity> {
    @Override
    public boolean isSatisfyBy(RouteRequestEntity object) {
        return isValid(object);
    }
    private boolean isValid(RouteRequestEntity object) {
        if (object.getOrigin().getLatitude().isEmpty() || object.getOrigin().getLongitude().isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The initial position of the route has to be entered.");
        }
        if (!getUtilText().validMatch(object.getOrigin().getLatitude(), ONLY_ANY_NUMBER) || !getUtilText().validMatch(object.getOrigin().getLongitude(), ONLY_ANY_NUMBER)) {
            throw CarpoolingCustomException.buildUserException("The initial position of the route no is a number.");
        }
        if (object.getDestination().getLatitude().isEmpty() || object.getDestination().getLongitude().isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The destination position of the route has to be entered.");
        }
        if (!getUtilText().validMatch(object.getDestination().getLatitude(), ONLY_ANY_NUMBER) || !getUtilText().validMatch(object.getDestination().getLongitude(), ONLY_ANY_NUMBER)) {
            throw CarpoolingCustomException.buildUserException("The destination position of the route no is a number.");
        }
        return true;
    }

}
