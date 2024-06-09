package co.edu.uco.application.specification.impl.routeselected;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static org.apache.tomcat.util.json.JSONParserConstants.ZERO;

@Component
public class RouteSelectedHasQuotaSpecification extends CompositeSpecification<RouteSelectedEntity> {

    @Override
    public boolean isSatisfyBy(RouteSelectedEntity object) {
        if (getUtilNumeric().isEqualThan(object.getRoute().getRouteCapacity(), ZERO)) {
            throw CarpoolingCustomException.buildUserException("The route selected has no quota available.");
        }
        return true;
    }
}
