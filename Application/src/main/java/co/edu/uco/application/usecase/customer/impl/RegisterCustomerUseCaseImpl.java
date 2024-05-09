package co.edu.uco.application.usecase.customer.impl;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.application.specification.impl.customer.ValidCustomerSpecification;
import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.port.jwt.PortAuthentication;
import co.edu.uco.port.input.bussiness.customer.RegisterCustomerUseCase;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {
    @Autowired
    private ValidCustomerSpecification validCustomerSpecification;
    @Autowired
    private PortAuthentication portAuthentication;

    @Override
    public void execute(CustomerEntity entity) {
        entity.setId(UtilUUID.getUtilUUID().getNewUUID());
        validCustomerSpecification.isSatisfyBy(entity);
        portAuthentication.customerSignUp(entity);
    }
}
