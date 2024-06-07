package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.infrastructure.adapter.persistence.VehicleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaVehicleRepository extends JpaRepository<VehicleData, UUID> {
    Optional<VehicleData> findByPlate(String plate);
    Optional<VehicleData> findByOwnerId(UUID driverId);
}
