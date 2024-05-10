package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.infrastructure.adapter.persistence.DriverPerVehicleData;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.SPACE;

@Component
public class JpaDriverPerVehicleRepositoryAdapter implements DriverPerVehicleRepository {

    private final JpaDriverPerVehicleRepository repository;
    private final EntityAssembler entityAssembler;

    public JpaDriverPerVehicleRepositoryAdapter(JpaDriverPerVehicleRepository repository, EntityAssembler entityAssembler) {
        this.repository = repository;
        this.entityAssembler = entityAssembler;
    }

    @Override
    public DriverPerVehicleEntity findById(UUID id) {
        DriverPerVehicleData data = repository.findById(id).get();
        return DriverPerVehicleEntity.build(id
                ,data.getVehicle().getOwner().getCustomer().getFirstName().concat(SPACE.concat(data.getVehicle().getOwner().getCustomer().getFirstSurname()))
                ,data.getVehicle().getPlate());
    }
}
