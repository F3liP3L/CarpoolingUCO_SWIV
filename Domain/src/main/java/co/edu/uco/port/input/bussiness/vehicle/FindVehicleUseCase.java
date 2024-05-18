package co.edu.uco.port.input.bussiness.vehicle;

import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.port.input.bussiness.FindUseCase;

import java.util.UUID;

public interface FindVehicleUseCase extends FindUseCase<VehicleEntity, UUID> {
}
