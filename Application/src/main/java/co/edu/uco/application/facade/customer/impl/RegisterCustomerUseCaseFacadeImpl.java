package co.edu.uco.application.facade.customer.impl;

import co.edu.uco.application.dto.CustomerDTO;
import co.edu.uco.application.facade.customer.RegisterCustomerUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.input.bussiness.customer.RegisterCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerUseCaseFacadeImpl implements RegisterCustomerUseCaseFacade {
    @Autowired
    private DTOAssembler<CustomerDTO, CustomerEntity> dtoAssembler;

    private final RegisterCustomerUseCase customerUseCase;

    public RegisterCustomerUseCaseFacadeImpl(RegisterCustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @Override
    public void execute(CustomerDTO dto) {
        CustomerEntity customerEntity = dtoAssembler.assembleDomain(dto);
        customerUseCase.execute(customerEntity);
    }
}
