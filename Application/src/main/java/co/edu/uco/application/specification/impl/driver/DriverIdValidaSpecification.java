package co.edu.uco.application.specification.impl.driver;


import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DriverIdValidaSpecification extends CompositeSpecification<DriverEntity> {
    @Override
    public boolean isSatisfyBy(DriverEntity object) {
        if (UtilObject.getUtilObject().isNull(object.getId())) {
            throw CarpoolingCustomException.buildUserException("Driver id can not be null");
        } else if (Objects.equals(object.getId().toString(),UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("Invalid driver id default value");
        }
        return true;
    }
}
