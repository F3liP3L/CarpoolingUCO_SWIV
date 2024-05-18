package co.edu.uco.port.input.bussiness.customer;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.input.bussiness.FindUseCase;

import java.util.UUID;

public interface FindCustomerUseCase extends FindUseCase<CustomerEntity, UUID> {
}
