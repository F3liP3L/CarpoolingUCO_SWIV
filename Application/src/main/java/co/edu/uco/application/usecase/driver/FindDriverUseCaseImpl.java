package co.edu.uco.application.usecase.driver;

import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.FindDriverUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindDriverUseCaseImpl implements FindDriverUseCase {

    private final DriverRepository driverRepository;

    public FindDriverUseCaseImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverEntity execute(UUID param) {
        Optional<DriverEntity> response = driverRepository.findById(param);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The driver you are trying to find does not exist.");
        }
        return response.get();
    }
}
