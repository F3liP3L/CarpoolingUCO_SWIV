package co.edu.uco.application.usecase.driver;

import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.DeleteDriverUseCase;
import co.edu.uco.port.output.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeleteDriverUseCaseImpl implements DeleteDriverUseCase {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void execute(DriverEntity domain) {
        driverRepository.deleteById(domain.getId());
    }
}
