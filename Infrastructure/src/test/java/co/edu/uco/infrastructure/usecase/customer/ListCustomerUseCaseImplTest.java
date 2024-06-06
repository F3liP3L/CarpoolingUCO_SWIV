package co.edu.uco.infrastructure.usecase.customer;

import co.edu.uco.application.usecase.customer.ListCustomerUseCaseImpl;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class ListCustomerUseCaseImplTest {
    static final UUID CUSTOMER_ID = UUID.randomUUID();
    CustomerEntity customerEntity = CustomerEntity.build();
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    ListCustomerUseCaseImpl listCustomerUseCaseImpl;

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
    }

    @Test
    void execute() {
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(customerEntity));

        listCustomerUseCaseImpl.execute(Optional.of(customerEntity));
        assertEquals(List.of(customerEntity), listCustomerUseCaseImpl.execute(Optional.of(customerEntity)));
        assertFalse(listCustomerUseCaseImpl.execute(Optional.of(customerEntity)).isEmpty());
        assertEquals(1, listCustomerUseCaseImpl.execute(Optional.of(customerEntity)).size());
    }
}
