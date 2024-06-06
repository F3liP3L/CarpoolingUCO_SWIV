package co.edu.uco.application.facade.driver;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.port.input.bussiness.FindUseCase;

public interface FindDriverByLicenseUseCaseFacade extends FindUseCase<DriverDTO, String> {
}
