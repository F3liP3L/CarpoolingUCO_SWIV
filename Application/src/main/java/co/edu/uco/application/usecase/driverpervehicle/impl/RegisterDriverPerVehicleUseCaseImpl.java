package co.edu.uco.application.usecase.driverpervehicle.impl;

import co.edu.uco.application.usecase.driverpervehicle.RegisterDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

@Service
public class RegisterDriverPerVehicleUseCaseImpl implements RegisterDriverPerVehicleUseCase {

    @Autowired
    private DriverPerVehicleRepository driverPerVehicleRepository;

    @Override
    public void execute(DriverPerVehicleEntity domain) {
        domain.setId(getUtilUUID().getNewUUID());
        driverPerVehicleRepository.save(domain);
    }
}
