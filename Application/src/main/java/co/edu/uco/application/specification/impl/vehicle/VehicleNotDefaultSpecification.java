package co.edu.uco.application.specification.impl.vehicle;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.VehicleEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;


@Component
public class VehicleNotDefaultSpecification extends CompositeSpecification<VehicleEntity> {
    @Override
    public boolean isSatisfyBy(VehicleEntity object) {
        return isValid(object);
    }

    private boolean isValid(VehicleEntity vehicle) {
        if (getUtilUUID().getStringFromUUID(vehicle.getId()).equals(UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("The id of the vehicle you are trying to register is the default id.");
        }
        if (getUtilNumeric().isLessOrEqualThan(vehicle.getCapacity(), UtilNumeric.ZERO)) {
            throw CarpoolingCustomException.buildUserException("The capacity must be greater than zero");
        }
        if (getUtilText().isEmpty(vehicle.getPlate())) {
            throw CarpoolingCustomException.buildUserException("The vehicle registration number cannot be an empty field.");
        }
        if (getUtilText().isEmpty(vehicle.getName())) {
            throw CarpoolingCustomException.buildUserException("The vehicle name cannot be an empty field.");
        }
        return true;
    }
}
