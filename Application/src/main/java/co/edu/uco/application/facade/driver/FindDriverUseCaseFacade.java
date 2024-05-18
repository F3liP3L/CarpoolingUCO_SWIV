package co.edu.uco.application.facade.driver;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.facade.FindUseCaseFacade;

import java.util.UUID;

public interface FindDriverUseCaseFacade extends FindUseCaseFacade<DriverDTO, UUID> {
}
