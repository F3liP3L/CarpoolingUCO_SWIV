package co.edu.uco.application.usecase.driver;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.ListUseCase;
import co.edu.uco.port.input.bussiness.driver.ListDriverUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAllDriverUseCaseIpl implements ListDriverUseCase {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<DriverEntity> execute(Optional<DriverEntity> dto) {
        if (dto.isEmpty()) {
            throw CarpoolingCustomException.buildTechnicalException("Can not find the driver, please try again");
        }
        return driverRepository.findAllDriver();
    }
}
