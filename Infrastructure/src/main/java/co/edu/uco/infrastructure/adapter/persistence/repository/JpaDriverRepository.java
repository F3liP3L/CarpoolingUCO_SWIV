package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.infrastructure.adapter.persistence.DriverData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaDriverRepository extends JpaRepository<DriverData, UUID> {
    Optional<DriverData> findDriverDataByCustomerId(UUID idCustomer);
    Optional<DriverData> findDriverDataByLicenseNumber(String licenseNumber);
}
