package co.edu.uco.port.output.repository;

import co.edu.uco.entity.VehicleEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository {

    Optional<VehicleEntity> findById(UUID id);

    List<VehicleEntity> findAll();

    Optional<VehicleEntity> findByPlate(String plate);

    Optional<VehicleEntity> findByDriverId(UUID driverId);

    void deleteById(UUID id);

    void save(VehicleEntity entity);
}
