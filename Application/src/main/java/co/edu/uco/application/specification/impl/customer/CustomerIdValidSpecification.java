package co.edu.uco.application.specification.impl.customer;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerIdValidSpecification extends CompositeSpecification<CustomerEntity> {

    @Override
    public boolean isSatisfyBy(CustomerEntity object) {
        if (UtilObject.getUtilObject().isNull(object.getId())) {
            throw CarpoolingCustomException.buildUserException("Customer id can not be null");
        } else if (UtilUUID.getUtilUUID().getStringFromUUID(object.getId()).length() != 36 || Objects.equals(object.getId().toString(),UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("Invalid customer id");
        }
        return true;
    }
}
