package co.edu.uco.application.usecase.driver;


import co.edu.uco.application.specification.impl.driver.ValidDriverSpecification;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.RegisterDriverUseCase;
import co.edu.uco.port.input.bussiness.customer.RegisterCustomerUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

@Service
public class RegisterDriverUseCaseImpl implements RegisterDriverUseCase {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private ValidDriverSpecification validDriverSpecification;
    @Autowired
    private RegisterCustomerUseCase registerCustomerUseCase;

    @Override
    public void execute(DriverEntity domain) {
        domain.setId(getUtilUUID().getNewUUID());
        CustomerEntity customer = domain.getCustomer();
        customer.setId(getUtilUUID().getNewUUID());
        domain.setCustomer(customer);
        validDriverSpecification.isSatisfyBy(domain);
        registerCustomerUseCase.execute(domain.getCustomer());
        driverRepository.save(domain);
    }
}
