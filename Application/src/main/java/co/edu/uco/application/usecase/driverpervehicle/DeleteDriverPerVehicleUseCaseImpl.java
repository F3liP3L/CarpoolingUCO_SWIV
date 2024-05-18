package co.edu.uco.application.usecase.driverpervehicle;

import co.edu.uco.port.input.bussiness.driverpervehicle.DeleteDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDriverPerVehicleUseCaseImpl implements DeleteDriverPerVehicleUseCase {

    @Autowired
    private DriverPerVehicleRepository driverPerVehicleRepository;

    @Override
    public void execute(DriverPerVehicleEntity domain) {
        driverPerVehicleRepository.deleteById(domain.getId());
    }
}
