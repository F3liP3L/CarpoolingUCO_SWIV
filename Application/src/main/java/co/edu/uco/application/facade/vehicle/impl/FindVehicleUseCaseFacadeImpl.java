package co.edu.uco.application.facade.vehicle.impl;

import co.edu.uco.application.dto.VehicleDTO;
import co.edu.uco.application.facade.vehicle.FindVehicleUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.port.input.bussiness.vehicle.FindVehicleUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindVehicleUseCaseFacadeImpl implements FindVehicleUseCaseFacade {

    private final DTOAssembler<VehicleDTO, VehicleEntity> dtoAssembler;
    private final FindVehicleUseCase findVehicleUseCase;

    public FindVehicleUseCaseFacadeImpl(DTOAssembler<VehicleDTO, VehicleEntity> dtoAssembler, FindVehicleUseCase findVehicleUseCase) {
        this.dtoAssembler = dtoAssembler;
        this.findVehicleUseCase = findVehicleUseCase;
    }

    @Override
    public VehicleDTO execute(UUID param) {
        return dtoAssembler.assembleDTO(findVehicleUseCase.execute(param));
    }
}
