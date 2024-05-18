package co.edu.uco.application.usecase.vehicle;

import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.port.input.bussiness.vehicle.DeleteVehicleUseCase;
import co.edu.uco.port.output.repository.VehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
@Transactional
public class DeleteVehicleUseCaseImpl implements DeleteVehicleUseCase {

    private final VehicleRepository repository;

    public DeleteVehicleUseCaseImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(UUID id) {
        try {
            if (repository.findById(id).isEmpty()) {
                throw CarpoolingCustomException.buildUserException("The vehicle has already been removed.");
            }
            repository.deleteById(id);
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred when trying to delete a vehicle.", exception.getMessage(), exception);
        }
    }
}
