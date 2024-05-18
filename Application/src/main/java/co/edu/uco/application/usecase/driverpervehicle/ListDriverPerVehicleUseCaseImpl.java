package co.edu.uco.application.usecase.driverpervehicle;

import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.port.input.bussiness.driverpervehicle.ListDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ListDriverPerVehicleUseCaseImpl implements ListDriverPerVehicleUseCase {

    @Autowired
    private DriverPerVehicleRepository repository;

    @Autowired
    private DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleEntity> entityAssembler;

    @Override
    public List<DriverPerVehicleEntity> execute(Optional<DriverPerVehicleEntity> dto) {
        if (dto.isEmpty()) {
            throw CarpoolingCustomException.buildTechnicalException("Can not find the driver per vehicle, please try again");
        }
        return repository.findAll();
    }
}
