package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.infrastructure.adapter.persistence.VehicleData;
import co.edu.uco.port.output.repository.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaVehicleRepositoryAdapter implements VehicleRepository {

    private final EntityAssembler entityAssembler;
    private final JpaVehicleRepository repository;

    public JpaVehicleRepositoryAdapter(EntityAssembler entityAssembler, JpaVehicleRepository repository) {
        this.entityAssembler = entityAssembler;
        this.repository = repository;
    }

    @Override
    public Optional<VehicleEntity> findById(UUID id) {
        return Optional.of(entityAssembler.assembleEntity(repository.findById(id), VehicleEntity.class));
    }

    @Override
    public List<VehicleEntity> findAll() {
        return repository.findAll().stream().map(entity -> entityAssembler.assembleDomain(entity, VehicleEntity.class)).toList();
    }

    @Override
    public Optional<VehicleEntity> findByPlate(String plate) {
        return Optional.of(entityAssembler.assembleEntity(repository.findByPlate(plate), VehicleEntity.class));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void save(VehicleEntity entity) {
        repository.save(entityAssembler.assembleDomain(entity, VehicleData.class));
    }
}

