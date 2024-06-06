package co.edu.uco.application.usecase.driver;

import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.FindDriverByLicenseUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindDriverByLicenseUseCaseImpl implements FindDriverByLicenseUseCase {

    private final DriverRepository repository;
    public FindDriverByLicenseUseCaseImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public DriverEntity execute(String param) {
        Optional<DriverEntity> response = repository.findDriverByLicenseNumber(param);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The driver with the sent license number does not exist");
        }
        return response.get();
    }
}
