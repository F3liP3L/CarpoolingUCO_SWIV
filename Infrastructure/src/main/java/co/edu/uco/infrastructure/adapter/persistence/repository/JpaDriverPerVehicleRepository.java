package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.infrastructure.adapter.persistence.DriverPerVehicleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaDriverPerVehicleRepository extends JpaRepository<DriverPerVehicleData, UUID> {

    Optional<DriverPerVehicleData> findDriverPerVehicleDataById(UUID id);
}
