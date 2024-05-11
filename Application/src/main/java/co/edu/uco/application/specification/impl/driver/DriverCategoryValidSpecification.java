package co.edu.uco.application.specification.impl.driver;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverCategoryValidSpecification extends CompositeSpecification<DriverEntity> {
    @Autowired
    private DriverRepository repository;

    @Override
    public boolean isSatisfyBy(DriverEntity object) {
        try {
            Optional<DriverEntity> response = repository.getDriverByCustomer(object.getCustomer().getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("Error try add driver, customer already exist");
            }
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException("Unexpect error try to add driver, please try again");
        }
        return true;
    }
}
