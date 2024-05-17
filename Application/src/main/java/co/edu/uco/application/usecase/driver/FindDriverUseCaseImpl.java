package co.edu.uco.application.usecase.driver;

import co.edu.uco.application.specification.impl.driver.DriverExistSpecification;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.FindDriverUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindDriverUseCaseImpl implements FindDriverUseCase {

    private final DriverRepository driverRepository;
    private final DriverExistSpecification driverExistSpecification;

    public FindDriverUseCaseImpl(DriverRepository driverRepository, DriverExistSpecification driverExistSpecification) {
        this.driverRepository = driverRepository;
        this.driverExistSpecification = driverExistSpecification;
    }

    @Override
    public DriverEntity execute(UUID param) {
        Optional<DriverEntity> response = driverRepository.findById(param);
        driverExistSpecification.andNot(driverExistSpecification).isSatisfyBy(response.get());
        return response.get();
    }
}
