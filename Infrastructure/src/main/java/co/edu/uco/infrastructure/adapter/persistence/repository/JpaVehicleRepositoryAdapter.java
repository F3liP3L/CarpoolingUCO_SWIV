package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.infrastructure.adapter.persistence.DriverPerVehicleData;
import co.edu.uco.port.output.repository.VehicleRepository;
import org.springframework.stereotype.Component;

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
    public VehicleEntity findById(UUID id) {
        return entityAssembler.assembleDomain(repository.findById(id).get(), VehicleEntity.class);
    }
}
