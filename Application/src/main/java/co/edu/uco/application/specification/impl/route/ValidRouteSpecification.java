package co.edu.uco.application.specification.impl.route;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.RouteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidRouteSpecification extends CompositeSpecification<RouteEntity> {

    @Autowired
    private RouteExistIdSpecification routeExistIdSpecification;
    @Autowired
    private RouteNotDefaultSpecification routeNotDefaultSpecification;
    @Autowired
    private RouteNotInvalidSpecification routeNotInvalidSpecification;

    @Override
    public boolean isSatisfyBy(RouteEntity object) {
        return routeNotDefaultSpecification.andNot(routeExistIdSpecification).and(routeNotInvalidSpecification).isSatisfyBy(object);
    }
}
