package co.edu.uco.application.specification.impl.customer;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class CustomerEmailValidSpecification extends CompositeSpecification<CustomerEntity> {
    @Autowired
    private CustomerRepository repository;

    public boolean isSatisfyBy(CustomerEntity object) {
        try {
            Optional<CustomerEntity> response = repository.findByCompanyEmail(object.getCompanyEmail());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("Please check the email listed, the phone email has already been registered.");
            }
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.buildUserException(exception.getUserMessage());
        }
        return true;
    }
}
