package co.edu.uco.port.input.bussiness.driver;

import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.FindUseCase;

import java.util.UUID;

public interface FindDriverUseCase extends FindUseCase<DriverEntity, UUID> {
}
