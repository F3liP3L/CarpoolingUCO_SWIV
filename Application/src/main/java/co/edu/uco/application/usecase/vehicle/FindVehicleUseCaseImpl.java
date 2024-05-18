package co.edu.uco.application.usecase.vehicle;

import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.port.input.bussiness.vehicle.FindVehicleUseCase;
import co.edu.uco.port.output.repository.VehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindVehicleUseCaseImpl implements FindVehicleUseCase {

    private final VehicleRepository repository;

    public FindVehicleUseCaseImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleEntity execute(UUID param) {
        Optional<VehicleEntity> response = repository.findById(param);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The vehicle does not exist.");
        }
        return response.get();
    }
}
