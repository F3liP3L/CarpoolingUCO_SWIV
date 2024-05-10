package co.edu.uco.application.usecase.customer.impl;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.input.bussiness.customer.FindCustomerUseCase;
import co.edu.uco.port.output.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity execute(CustomerEntity domain) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(domain.getId());
        return customerEntity.get();
    }
}
