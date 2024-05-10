package co.edu.uco.application.specification.route;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import static org.apache.tomcat.util.json.JSONParserConstants.ZERO;

@Component
public class RouteNotDefaultSpecification extends CompositeSpecification<RouteEntity> {
    @Override
    public boolean isSatisfyBy(RouteEntity object) {
        return isValid(object);
    }

    private boolean isValid(RouteEntity route) {
        if (UtilUUID.getUtilUUID().getStringFromUUID(route.getId()).equals(UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("The id the route is default.");
        }
        if (UtilNumeric.getUtilNumeric().isLessOrEqualThan(route.getRouteCapacity(), ZERO)) {
            throw CarpoolingCustomException.buildUserException("The capacity must be greater than zero");
        }
        return true;
    }
}
