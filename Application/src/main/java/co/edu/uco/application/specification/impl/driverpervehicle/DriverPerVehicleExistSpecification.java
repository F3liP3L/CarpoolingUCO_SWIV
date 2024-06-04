package co.edu.uco.application.specification.impl.driverpervehicle;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverPerVehicleExistSpecification extends CompositeSpecification<DriverPerVehicleEntity> {

    private final DriverPerVehicleRepository driverPerVehicleRepository;

    public DriverPerVehicleExistSpecification(DriverPerVehicleRepository driverPerVehicleRepository) {
        this.driverPerVehicleRepository = driverPerVehicleRepository;
    }

    @Override
    public boolean isSatisfyBy(DriverPerVehicleEntity object) {
        return isExist(object);
    }

    private boolean isExist(DriverPerVehicleEntity driverPerVehicle) {
        Optional<DriverPerVehicleEntity> response = driverPerVehicleRepository.findById(driverPerVehicle.getId());
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("A driver per vehicle with the sent identifier already exists.!");
        }
        return true;
    }
}
