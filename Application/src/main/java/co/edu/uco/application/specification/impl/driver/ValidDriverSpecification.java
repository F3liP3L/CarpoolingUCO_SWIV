package co.edu.uco.application.specification.impl.driver;


import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.application.specification.impl.customer.ValidCustomerSpecification;
import co.edu.uco.entity.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidDriverSpecification extends CompositeSpecification<DriverEntity> {
    @Autowired
    private DriverLicenseValidSpecification driverLicenseValidSpecification;
    @Autowired
    private DriverIdValidaSpecification driverIdValidaSpecification;
    @Autowired
    private DriverCategoryValidSpecification driverCategoryValidSpecification;
    @Autowired
    private ValidCustomerSpecification validCustomerSpecification;

    @Override
    public boolean isSatisfyBy(DriverEntity object) {
        return driverLicenseValidSpecification.and(driverIdValidaSpecification).and(driverCategoryValidSpecification)
                .isSatisfyBy(object) && validCustomerSpecification.isSatisfyBy(object.getCustomer());
    }
}
