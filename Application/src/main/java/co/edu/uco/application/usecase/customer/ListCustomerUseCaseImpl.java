package co.edu.uco.application.usecase.customer;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.input.bussiness.customer.ListCustomersUseCase;
import co.edu.uco.port.output.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListCustomerUseCaseImpl implements ListCustomersUseCase {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> execute(Optional<CustomerEntity> param) {
        return customerRepository.findAll();
    }
}
