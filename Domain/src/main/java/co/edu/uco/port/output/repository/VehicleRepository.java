package co.edu.uco.port.output.repository;

import co.edu.uco.entity.VehicleEntity;

import java.util.UUID;

public interface VehicleRepository {
    VehicleEntity findById(UUID id);
}
