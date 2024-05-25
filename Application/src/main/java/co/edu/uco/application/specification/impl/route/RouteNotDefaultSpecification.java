package co.edu.uco.application.specification.impl.route;

import co.edu.uco.application.specification.CompositeSpecification;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;


@Component
public class RouteNotDefaultSpecification extends CompositeSpecification<RouteEntity> {
    @Override
    public boolean isSatisfyBy(RouteEntity object) {
        return isValid(object);
    }

    private boolean isValid(RouteEntity route) {
        if (getUtilUUID().getStringFromUUID(route.getId()).equals(UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("The id the route is default.");
        }
        if (getUtilNumeric().isLessOrEqualThan(route.getRouteCapacity(), ZERO)) {
            throw CarpoolingCustomException.buildUserException("The capacity must be greater than zero");
        }
        return true;
    }
}
