package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.infrastructure.adapter.persistence.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerData, UUID>{
    Optional<CustomerData> findCustomerDataByCompanyEmail(String email);
    Optional<CustomerData> findByPhone(String phone);
    Optional<CustomerData> findByDni(String phone);
}
