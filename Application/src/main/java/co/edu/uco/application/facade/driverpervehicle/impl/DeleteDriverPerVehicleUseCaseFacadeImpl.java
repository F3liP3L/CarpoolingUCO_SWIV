package co.edu.uco.application.facade.driverpervehicle.impl;

import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.facade.driverpervehicle.DeleteDriverPerVehicleUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.port.input.bussiness.driverpervehicle.DeleteDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDriverPerVehicleUseCaseFacadeImpl implements DeleteDriverPerVehicleUseCaseFacade {
    @Autowired
    private DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleEntity> dtoAssembler;
    @Autowired
    private DeleteDriverPerVehicleUseCase driverPerVehicleUseCase;

    @Override
    public void execute(DriverPerVehicleDTO domain) {
        driverPerVehicleUseCase.execute(dtoAssembler.assembleDomain(domain));
    }
}
