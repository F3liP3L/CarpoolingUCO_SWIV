package co.edu.uco.repository;

import co.edu.uco.domain.CustomerDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<CustomerDomain> findById(UUID id);
    List<CustomerDomain> findAll();
    Optional<CustomerDomain> findByCompanyEmail(String email);
    void deleteById(UUID id);
    CustomerDomain save(CustomerDomain entity);
    Optional<CustomerDomain> findDni(String dni);
    Optional<CustomerDomain> findPhone(int phone);
}
