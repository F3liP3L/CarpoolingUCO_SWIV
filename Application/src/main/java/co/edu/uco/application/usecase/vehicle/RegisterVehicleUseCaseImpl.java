package co.edu.uco.application.usecase.vehicle;

import co.edu.uco.application.specification.impl.vehicle.ValidVehicleSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.port.input.bussiness.vehicle.RegisterVehicleUseCase;
import co.edu.uco.port.output.repository.VehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RegisterVehicleUseCaseImpl implements RegisterVehicleUseCase {

    private final VehicleRepository repository;
    private final ValidVehicleSpecification specification;

    public RegisterVehicleUseCaseImpl(VehicleRepository repository, ValidVehicleSpecification specification) {
        this.repository = repository;
        this.specification = specification;
    }

    @Override
    public void execute(VehicleEntity domain) {
        try {
            specification.isSatisfyBy(domain);
            repository.save(domain);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred when registering a vehicle.", exception.getMessage(), exception);
        }
    }
}
