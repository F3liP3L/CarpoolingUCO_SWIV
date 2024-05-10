package co.edu.uco.application.specification.impl.customer;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerPhoneValidSpecification extends CompositeSpecification<CustomerEntity> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public boolean isSatisfyBy(CustomerEntity object) {
        int count = 6;
        if (object.getPhone().length() < count) {
            throw CarpoolingCustomException.buildUserException("The size of the phone number is not allowed, it is too short");
        }
        try {
            Optional<CustomerEntity> response = repository.findPhone(object.getPhone());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("Please check the phone number listed, the phone number " +
                        "has already been registered.");
            }
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException(exception.getUserMessage());
        }
        return true;
    }
}
