package co.edu.uco.application.usecase.driver;

import co.edu.uco.port.input.bussiness.driver.DeleteDriverUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
public class DeleteDriverUseCaseImpl implements DeleteDriverUseCase {

    private final DriverRepository driverRepository;

    public DeleteDriverUseCaseImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void execute(UUID id) {
        if (driverRepository.findById(id).isEmpty()) {
            throw CarpoolingCustomException.buildTechnicalException("Driver not found", String.format("The Driver with id %s does not exist in the database", id));
        }
        driverRepository.deleteById(id);
    }
}
