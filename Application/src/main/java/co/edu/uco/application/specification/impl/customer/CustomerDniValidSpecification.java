package co.edu.uco.application.specification.impl.customer;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static co.edu.uco.crosscutting.util.UtilText.ONLY_CHARACTERS_AND_NUMBERS;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

@Component
public class CustomerDniValidSpecification extends CompositeSpecification<CustomerEntity> {
    @Autowired
    private CustomerRepository repository;

    @Override
    public boolean isSatisfyBy(CustomerEntity object) {
        Optional<CustomerEntity> response = repository.findDni(object.getDni());
        if (response.isPresent()){
            throw CarpoolingCustomException.buildUserException("Please check the dni number listed, the dni number has already been registered.");
        }
        if (!getUtilText().validMatch(object.getDni(), ONLY_CHARACTERS_AND_NUMBERS)) {
            throw CarpoolingCustomException.buildUserException("The dni number is not allowed, it must contain only numbers and letters.");
        }
        return true;
    }
}
