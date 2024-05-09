package co.edu.uco.application.specification.impl.customer;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerDniValidSpecification extends CompositeSpecification<CustomerEntity> {
    @Autowired
    private CustomerRepository repository;

    @Override
    public boolean isSatisfyBy(CustomerEntity object) {
        try {
            Optional<CustomerEntity> response = repository.findDni(object.getDni());
            if (response.isPresent()){
                throw CarpoolingCustomException.buildUserException("Please check the dni number listed, the dni number has already been registered.");
            }
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.buildUserException(exception.getUserMessage());
        }
        return true;
    }
}
