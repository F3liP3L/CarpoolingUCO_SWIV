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
        Optional<DriverEntity> response = repository.findDriverByLicenseNumber(object.getLicenseNumber());
        if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("Exist driver with the same license number registered");
        }
        return true;
    }
}
