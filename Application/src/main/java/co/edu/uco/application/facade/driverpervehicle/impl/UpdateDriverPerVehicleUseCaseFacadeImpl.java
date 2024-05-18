package co.edu.uco.application.facade.driverpervehicle.impl;


import co.edu.uco.application.facade.driverpervehicle.UpdateDriverPerVehicleUseCaseFacade;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import org.springframework.stereotype.Component;



@Component
public class UpdateDriverPerVehicleUseCaseFacadeImpl implements UpdateDriverPerVehicleUseCaseFacade {

    private final DriverPerVehicleRepository repository;

    public UpdateDriverPerVehicleUseCaseFacadeImpl(DriverPerVehicleRepository repository) {
        this.repository = repository;
    }
}
