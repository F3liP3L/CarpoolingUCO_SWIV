package co.edu.uco.port.output.repository;

import co.edu.uco.entity.DriverEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverRepository {
    Optional<DriverEntity> findById(UUID id);
    Optional<DriverEntity> getDriverByCustomer(UUID idCustomer);
    Optional<DriverEntity> findDriverByLicenseNumber(String licenseNumber);
    void deleteById(UUID id);
    List<DriverEntity> findAllDriver();
    void save(DriverEntity driverEntity);
}
