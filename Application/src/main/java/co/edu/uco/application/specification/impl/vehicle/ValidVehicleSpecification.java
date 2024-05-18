package co.edu.uco.application.specification.impl.vehicle;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidVehicleSpecification extends CompositeSpecification<VehicleEntity> {
    @Autowired
    private VehicleNotDefaultSpecification notDefaultSpecification;
    @Autowired
    private VehicleExistSpecification existSpecification;
    @Autowired
    private VehicleNotInvalidSpecification notInvalidSpecification;

    @Override
    public boolean isSatisfyBy(VehicleEntity object) {
        return notDefaultSpecification.and(notInvalidSpecification).andNot(existSpecification).isSatisfyBy(object);
    }

}
