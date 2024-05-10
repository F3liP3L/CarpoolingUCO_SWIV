package co.edu.uco.port.output.repository;

import co.edu.uco.entity.DriverPerVehicleEntity;

import java.util.UUID;

public interface DriverPerVehicleRepository {

    DriverPerVehicleEntity findById(UUID id);
}
