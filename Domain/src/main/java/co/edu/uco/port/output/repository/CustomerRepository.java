package co.edu.uco.port.output.repository;

import co.edu.uco.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<CustomerEntity> findById(UUID id);
    List<CustomerEntity> findAll();
    Optional<CustomerEntity> findByCompanyEmail(String email);
    void deleteById(UUID id);
    void save(CustomerEntity entity);
    Optional<CustomerEntity> findDni(String dni);
    Optional<CustomerEntity> findPhone(String phone);
}
