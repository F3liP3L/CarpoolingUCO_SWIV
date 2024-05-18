package co.edu.uco.application.facade.vehicle.impl;

import co.edu.uco.application.dto.VehicleDTO;
import co.edu.uco.application.facade.vehicle.RegisterVehicleUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.port.input.bussiness.vehicle.RegisterVehicleUseCase;
import org.springframework.stereotype.Service;

@Service
public class RegisterVehicleUseCaseFacadeImpl implements RegisterVehicleUseCaseFacade {

    private final RegisterVehicleUseCase registerVehicleUseCase;
    private final DTOAssembler<VehicleDTO, VehicleEntity> dtoAssembler;

    public RegisterVehicleUseCaseFacadeImpl(RegisterVehicleUseCase registerVehicleUseCase, DTOAssembler<VehicleDTO, VehicleEntity> dtoAssembler) {
        this.registerVehicleUseCase = registerVehicleUseCase;
        this.dtoAssembler = dtoAssembler;
    }

    @Override
    public void execute(VehicleDTO dto) {
        registerVehicleUseCase.execute(dtoAssembler.assembleDomain(dto));
    }
}
