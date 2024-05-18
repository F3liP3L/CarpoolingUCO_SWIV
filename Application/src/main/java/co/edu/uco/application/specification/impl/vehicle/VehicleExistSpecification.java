package co.edu.uco.application.specification.impl.vehicle;


import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.port.output.repository.VehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleExistSpecification extends CompositeSpecification<VehicleEntity> {
    @Autowired
    private VehicleRepository repository;
    @Override
    public boolean isSatisfyBy(VehicleEntity object) {
        return isExist(object);
    }

    private boolean isExist(VehicleEntity vehicle) {
        try {
            Optional<VehicleEntity> response = repository.findById(vehicle.getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("The vehicle you are trying to register already exists.");
            }
                response = repository.findByPlate(vehicle.getPlate());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("A vehicle is already registered with the license plate entered.");
            }
            return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected exception occurred when registering the vehicle.", exception.getMessage(), exception);
        }
    }
}
