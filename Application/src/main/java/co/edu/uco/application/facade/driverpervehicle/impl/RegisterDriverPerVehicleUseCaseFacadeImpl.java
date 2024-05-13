package co.edu.uco.application.facade.driverpervehicle.impl;

import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.facade.driverpervehicle.RegisterDriverPerVehicleUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.application.usecase.driverpervehicle.RegisterDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterDriverPerVehicleUseCaseFacadeImpl implements RegisterDriverPerVehicleUseCaseFacade {

    private final DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleEntity> dtoAssembler;
    private final RegisterDriverPerVehicleUseCase driverPerVehicleUseCase;

    public RegisterDriverPerVehicleUseCaseFacadeImpl(DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleEntity> dtoAssembler, RegisterDriverPerVehicleUseCase driverPerVehicleUseCase) {
        this.dtoAssembler = dtoAssembler;
        this.driverPerVehicleUseCase = driverPerVehicleUseCase;
    }

    @Override
    public void execute(DriverPerVehicleDTO domain) {
        driverPerVehicleUseCase.execute(dtoAssembler.assembleDomain(domain));
    }
}
