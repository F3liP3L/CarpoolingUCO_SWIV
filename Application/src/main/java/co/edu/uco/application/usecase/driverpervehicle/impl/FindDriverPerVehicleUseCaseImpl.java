package co.edu.uco.application.usecase.driverpervehicle.impl;


import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.application.usecase.driverpervehicle.FindDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class FindDriverPerVehicleUseCaseImpl implements FindDriverPerVehicleUseCase {

    @Autowired
    private DriverPerVehicleRepository driverPerVehicleRepository;

    @Autowired
    private DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleEntity> dtoAssembler;

    @Override
    public DriverPerVehicleDTO execute(DriverPerVehicleDTO dto) {
        Optional<DriverPerVehicleEntity> response = driverPerVehicleRepository.findDriverPerVehicleEntityById(dto.getId());
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The driver per vehicle with the sent id does not exist");
        }
        return dtoAssembler.assembleDTO(response.get());
    }
}
