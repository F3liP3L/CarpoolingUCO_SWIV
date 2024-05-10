package co.edu.uco.application.specification.route;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.RouteRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidRouteRequestSpecification extends CompositeSpecification<RouteRequestEntity> {
    @Autowired
    private RouteRequestNotDefaultSpecification notDefaultSpecification;

    @Override
    public boolean isSatisfyBy(RouteRequestEntity object) {
        return notDefaultSpecification.isSatisfyBy(object);
    }
}
