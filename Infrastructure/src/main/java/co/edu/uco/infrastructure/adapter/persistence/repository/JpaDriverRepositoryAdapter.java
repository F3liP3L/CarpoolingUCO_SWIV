package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.infrastructure.adapter.persistence.DriverData;
import co.edu.uco.port.output.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JpaDriverRepositoryAdapter implements DriverRepository {

    @Autowired
    private JpaDriverRepository repository;

    @Autowired
    private EntityAssembler entityAssembler;

    @Override
    public void save(DriverEntity driverEntity) {
        repository.save(entityAssembler.assembleEntity(driverEntity, DriverData.class));
    }

    @Override
    public Optional<DriverEntity> findById(UUID id) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findById(id), DriverEntity.class));
    }

    @Override
    public Optional<DriverEntity> getDriverByCustomer(UUID idCustomer) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findDriverDataByCustomerId(idCustomer), DriverEntity.class));
    }

    @Override
    public Optional<DriverEntity> findDriverByLicenseNumber(String licenseNumber) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findDriverDataByLicenseNumber(licenseNumber), DriverEntity.class));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<DriverEntity> findAllDriver() {
        return repository.findAll().stream().map(elem -> entityAssembler.assembleEntity(elem, DriverEntity.class)).toList();
    }
}
