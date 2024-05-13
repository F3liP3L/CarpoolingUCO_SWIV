package co.edu.uco.application.specification.impl.driver;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverCategoryValidSpecification extends CompositeSpecification<DriverEntity> {

    private final DriverRepository repository;

    public DriverCategoryValidSpecification(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isSatisfyBy(DriverEntity object) {
        try {
            Optional<DriverEntity> response = repository.getDriverByCustomer(object.getCustomer().getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("The driver is already registered with this role in the application.");
            }
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException("Unexpect error try to add driver, please try again");
        }
        return true;
    }
}
