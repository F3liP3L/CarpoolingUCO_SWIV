package co.edu.uco.application.specification.impl.driver;


import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidDriverSpecification extends CompositeSpecification<DriverEntity> {
    @Autowired
    private DriverLicenseValidSpecification driverLicenseValidSpecification;
    @Autowired
    private DriverIdValidSpecification driverIdValidSpecification;
    @Autowired
    private DriverCategoryValidSpecification driverCategoryValidSpecification;

    @Override
    public boolean isSatisfyBy(DriverEntity object) {
        return driverLicenseValidSpecification.and(driverIdValidSpecification).and(driverCategoryValidSpecification)
                .isSatisfyBy(object);
    }
}
