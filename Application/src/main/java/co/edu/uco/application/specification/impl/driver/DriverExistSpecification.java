package co.edu.uco.application.specification.impl.driver;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverExistSpecification extends CompositeSpecification<DriverEntity> {
    @Autowired
    private DriverRepository repository;
    @Override
    public boolean isSatisfyBy(DriverEntity object) {
        return isExist(object);
    }

    private boolean isExist(DriverEntity driver) {
        try {
            Optional<DriverEntity> response = repository.findById(driver.getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("The driver you are trying to register exists.");
            }
            return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected exception occurred when registering the vehicle.", exception.getMessage(), exception);
        }
    }
}
