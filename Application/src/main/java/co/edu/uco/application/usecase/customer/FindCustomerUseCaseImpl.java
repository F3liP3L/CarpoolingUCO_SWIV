package co.edu.uco.application.usecase.customer;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.input.bussiness.customer.FindCustomerUseCase;
import co.edu.uco.port.output.repository.CustomerRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity execute(UUID domain) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(domain);
        if (customerEntity.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The customer does not exist in the application.");
        }
        return customerEntity.get();
    }
}
