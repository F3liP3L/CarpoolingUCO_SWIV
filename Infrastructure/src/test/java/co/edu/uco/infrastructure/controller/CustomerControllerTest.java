package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.CustomerDTO;
import co.edu.uco.application.facade.customer.RegisterCustomerUseCaseFacade;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.port.input.bussiness.customer.FindCustomerUseCase;
import co.edu.uco.port.input.bussiness.customer.ListCustomersUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
    static final UUID CUSTOMER_ID = UUID.randomUUID();

    CustomerEntity customerEntity = CustomerEntity.build();
    CustomerEntity customerEntityEmpty = CustomerEntity.build();

    CustomerDTO customerDTO = CustomerDTO.create();

    static final List<CustomerEntity> customerEntityList = new ArrayList<>();

    @Mock
    FindCustomerUseCase findCustomerUseCase;

    @Mock
    ListCustomersUseCase listCustomersUseCase;

    @Mock
    RegisterCustomerUseCaseFacade customerUseCase;

    @InjectMocks
    CustomerController customerController;

    private TestRestTemplate restTemplate;

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
        customerEntity.setPhone("123456789");
        customerEntity.setRol(1);

        customerDTO.setId(CUSTOMER_ID);
        customerDTO.setFirstName("Juan");
        customerDTO.setSecondName("Felipe");
        customerDTO.setFirstSurname("Cardona");
        customerDTO.setSecondSurname("Lora");
        customerDTO.setDni("123456789");
        customerDTO.setPassword("123456789");
        customerDTO.setCompanyEmail("jua.cardona@gmail.com");
        customerDTO.setPhone("123456789");
        customerDTO.setRol(1);
    }

    @Test
    void getCustomer() throws GeneralException {
        when(findCustomerUseCase.execute(CUSTOMER_ID)).thenReturn(customerEntity);
        final ResponseEntity<Response<CustomerEntity>> response = customerController.getCustomer(CUSTOMER_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Objects.requireNonNull(response.getBody()).getData().get(0), customerEntity);
    }

    @Test
    void listCustomer() throws GeneralException {
        when(listCustomersUseCase.execute(Optional.empty())).thenReturn(customerEntityList);
        final ResponseEntity<Response<List<CustomerEntity>>> response = customerController.listCustomer();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customerEntityList, Objects.requireNonNull(response.getBody()).getData().get(0));
    }

    @Test
    void createCustomer() throws GeneralException {
        final ResponseEntity<Response<CustomerDTO>> response = customerController.createCustomer(customerDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customerDTO, Objects.requireNonNull(response.getBody()).getData().get(0));
    }
}
