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
        DriverPerVehicleData data = entityAssembler.assembleDomain(driverPerVehicleEntity, DriverPerVehicleData.class);
        data.getStatus().setId(UUID.fromString("6c802e33-88d5-4c5e-bf2a-85d82b7da87e"));
        repository.save(data);
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

    @Override
    public Optional<DriverPerVehicleEntity> findByVehicleOwnerId(UUID id) {
        return repository.findByVehicleOwnerId(id).map(data -> entityAssembler.assembleDomain(data, DriverPerVehicleEntity.class));
    }
}
