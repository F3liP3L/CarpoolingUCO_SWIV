package co.edu.uco.application.usecase.driverpervehicle;

import co.edu.uco.port.input.bussiness.driverpervehicle.RegisterDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import org.springframework.stereotype.Service;

import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

@Service
public class RegisterDriverPerVehicleUseCaseImpl implements RegisterDriverPerVehicleUseCase {

    private final DriverPerVehicleRepository driverPerVehicleRepository;

    public RegisterDriverPerVehicleUseCaseImpl(DriverPerVehicleRepository driverPerVehicleRepository) {
        this.driverPerVehicleRepository = driverPerVehicleRepository;
    }

    @Override
    public void execute(DriverPerVehicleEntity domain) {
        domain.setId(getNewUUID());
        domain.setStatus("Activo");
        driverPerVehicleRepository.save(domain);
    }
}
