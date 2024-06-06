package co.edu.uco.infrastructure.usecase.customer;

import co.edu.uco.application.specification.impl.customer.ValidCustomerSpecification;
import co.edu.uco.application.usecase.customer.RegisterCustomerUseCaseImpl;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.input.jwt.PortAuthentication;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegisterCustomerUseCaseImplTest {

    static final UUID CUSTOMER_ID = UUID.randomUUID();

    CustomerEntity customerEntity = CustomerEntity.build();

    @Mock
    ValidCustomerSpecification validCustomerSpecification;
    @Mock
    PortAuthentication portAuthentication;

    @InjectMocks
    RegisterCustomerUseCaseImpl customerUseCase;

    @BeforeEach
    void setUp() {
        customerEntity.setId(CUSTOMER_ID);
        customerEntity.setFirstName("Juan");
        customerEntity.setSecondName("Felipe");
        customerEntity.setFirstSurname("Cardona");
        customerEntity.setSecondSurname("Lora");
        customerEntity.setDni("123456789");
        customerEntity.setPassword("123456789");
        customerEntity.setCompanyEmail("jua.cardona@gmail.com");
        customerEntity.setPhone("189465165");
        customerEntity.setRol(1);
    }

    @Test
    void createCustomer() throws CarpoolingCustomException {
        Mockito.when(validCustomerSpecification.isSatisfyBy(customerEntity)).thenReturn(true);
        customerUseCase.execute(customerEntity);

        Mockito.verify(portAuthentication, Mockito.times(1)).customerSignUp(customerEntity);
    }

    @Test
    void createBadCustomer() throws CarpoolingCustomException {
        Mockito.when(validCustomerSpecification.isSatisfyBy(customerEntity)).thenReturn(true);
        customerUseCase.execute(customerEntity);

        Mockito.verify(portAuthentication, Mockito.times(1)).customerSignUp(customerEntity);
        assertTrue(customerEntity.getPhone().length() >= 6, "The size of the phone number is not allowed, it is too short");
        assertTrue(customerEntity.getFirstName().length() >= 2, "The size of the first name is not allowed, it is too short");
        assertTrue(customerEntity.getFirstSurname().length() >= 2, "The size of the first surname is not allowed, it is too short");
        assertTrue(customerEntity.getPassword().length() >= 8, "The size of the password is not allowed, it is too short");
        assertTrue(customerEntity.getCompanyEmail().length() >= 6, "The size of the email is not allowed, it is too short");
        assertTrue(customerEntity.getDni().length() >= 4, "The size of the DNI number is not allowed, it is too short");
    }
}
