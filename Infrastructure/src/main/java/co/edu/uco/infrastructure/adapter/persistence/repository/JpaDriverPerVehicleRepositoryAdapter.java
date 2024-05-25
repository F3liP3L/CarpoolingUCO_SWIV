package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.infrastructure.adapter.persistence.DriverPerVehicleData;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaDriverPerVehicleRepositoryAdapter implements DriverPerVehicleRepository {

    private final JpaDriverPerVehicleRepository repository;
    private final EntityAssembler entityAssembler;

    public JpaDriverPerVehicleRepositoryAdapter(JpaDriverPerVehicleRepository repository, EntityAssembler entityAssembler) {
        this.repository = repository;
        this.entityAssembler = entityAssembler;
    }

    @Override
    public Optional<DriverPerVehicleEntity> findById(UUID id) {
        return repository.findById(id).map(data -> entityAssembler.assembleDomain(data, DriverPerVehicleEntity.class));
    }

    @Override
    public void save(DriverPerVehicleEntity driverPerVehicleEntity) {
        repository.save(entityAssembler.assembleDomain(driverPerVehicleEntity, DriverPerVehicleData.class));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<DriverPerVehicleEntity> findAll() {
        return repository.findAll().stream().map(data -> entityAssembler.assembleDomain(data, DriverPerVehicleEntity.class)).toList();
    }

    @Override
    public Optional<DriverPerVehicleEntity> findDriverPerVehicleEntityById(UUID id) {
        return repository.findDriverPerVehicleDataById(id).map(data -> entityAssembler.assembleDomain(data, DriverPerVehicleEntity.class));
    }
}
