package co.edu.uco.port.output.repository;

import co.edu.uco.entity.DriverPerVehicleEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverPerVehicleRepository {

    Optional<DriverPerVehicleEntity> findById(UUID id);
    void save(DriverPerVehicleEntity driverPerVehicleEntity);
    void deleteById(UUID id);
    List<DriverPerVehicleEntity> findAll();
    Optional<DriverPerVehicleEntity> findDriverPerVehicleEntityById(UUID id);
    Optional<DriverPerVehicleEntity> findByVehicleOwnerId(UUID id);
}
