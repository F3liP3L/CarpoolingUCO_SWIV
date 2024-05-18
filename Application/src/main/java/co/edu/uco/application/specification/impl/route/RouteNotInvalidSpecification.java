package co.edu.uco.application.specification.impl.route;


import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;

@Component
public class RouteNotInvalidSpecification extends CompositeSpecification<RouteEntity> {
    private static final Integer CAPACITY_MIN = 1;
    private static final Integer CAPACITY_MAX = 4;

    @Override
    public boolean isSatisfyBy(RouteEntity object) {
        return isDefault(object);
    }

    private boolean isDefault(RouteEntity route) {
        if (!UtilNumeric.getUtilNumeric().isBetween(route.getRouteCapacity(), CAPACITY_MIN, CAPACITY_MAX, true, true)) {
            throw CarpoolingCustomException.buildUserException("Route capacity exceeds maximum allowable quantity");
        }
        if (route.getPointOfInterest().isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The point of interest through which it is intended to pass does not exist.");
        }
        if (getUtilDate().isBefore(getUtilDate().getLocalDataTimeADate(route.getRouteTime()))) {
            throw CarpoolingCustomException.buildUserException("The time to start the route has expired");
        }
        return true;
    }
}
