package co.edu.uco.application.usecase.driverpervehicle;


import co.edu.uco.port.input.bussiness.driverpervehicle.FindDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class FindDriverPerVehicleUseCaseImpl implements FindDriverPerVehicleUseCase {

    private final DriverPerVehicleRepository driverPerVehicleRepository;

    public FindDriverPerVehicleUseCaseImpl(DriverPerVehicleRepository driverPerVehicleRepository) {
        this.driverPerVehicleRepository = driverPerVehicleRepository;
    }

    @Override
    public DriverPerVehicleEntity execute(UUID id) {
        Optional<DriverPerVehicleEntity> response = driverPerVehicleRepository.findDriverPerVehicleEntityById(id);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The driver per vehicle with the sent id does not exist");
        }
        return response.get();
    }
}
