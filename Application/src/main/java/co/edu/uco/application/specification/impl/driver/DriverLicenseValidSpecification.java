package co.edu.uco.application.specification.impl.driver;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

@Component
public class DriverLicenseValidSpecification extends CompositeSpecification<DriverEntity> {

    private static final Integer LICENSE_NUMBER_MIN = 6;

    @Override
    public boolean isSatisfyBy(DriverEntity object) {
        if (UtilNumeric.getUtilNumeric().isGreaterThan(object.getLicenseNumber().length(), LICENSE_NUMBER_MIN)){
            throw CarpoolingCustomException.buildUserException("Please check the license number is to short, error try to add driver");
        }
        return true;
    }
}
