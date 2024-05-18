package co.edu.uco.application.usecase.driver;

import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.ListAllDriverUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAllDriverUseCaseImpl implements ListAllDriverUseCase {

    private final DriverRepository driverRepository;

    public ListAllDriverUseCaseImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<DriverEntity> execute(Optional<DriverEntity> dto) {
        if (dto.isEmpty()) {
            throw CarpoolingCustomException.buildTechnicalException("Can not find the driver, please try again");
        }
        return driverRepository.findAllDriver();
    }
}
