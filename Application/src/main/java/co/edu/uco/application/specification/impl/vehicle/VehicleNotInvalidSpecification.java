package co.edu.uco.application.specification.impl.vehicle;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.constants.ConstantsCarpooling;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

@Component
public class VehicleNotInvalidSpecification extends CompositeSpecification<VehicleEntity> {
    private static final Integer CAPACITY_MIN = 1;
    private static final Integer CAPACITY_MAX = 50;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public boolean isSatisfyBy(VehicleEntity object) {
        return isValid(object);
    }

    private boolean isValid(VehicleEntity vehicle) {
        if (getUtilText().validMatch(vehicle.getName(), UtilText.ONLY_ANY_NUMBER)) {
            throw CarpoolingCustomException.buildUserException("The name of the vehicle may not be composed of numbers only.");
        }
        if (!getUtilText().validMatch(vehicle.getPlate(), ConstantsCarpooling.PLATE)) {
            throw CarpoolingCustomException.buildUserException("The plate entered does not comply with the appropriate characters.");
        }
        if (!getUtilNumeric().isBetween(vehicle.getCapacity(), CAPACITY_MIN, CAPACITY_MAX, true, true)) {
            throw CarpoolingCustomException.buildUserException("The capacity of your vehicle exceeds the maximum amount allowed.");
        }
        if (driverRepository.findById(vehicle.getOwner().getId()).isEmpty()) {
            throw CarpoolingCustomException.buildUserException("There is no driver with the identifier sent.");
        }
        return true;
    }

}
