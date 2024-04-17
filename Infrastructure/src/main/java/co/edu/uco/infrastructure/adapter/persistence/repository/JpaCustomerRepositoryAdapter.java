package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Juan Felipe Cardona;
 * Email: felipe7u7432@gmail.com
 * @version id: <b>CarpoolingUCO_SWIV/b> 13/4/2024, 21:39
 **/
@Component
public class JpaCustomerRepositoryAdapter implements CustomerRepository {

    private final JpaCustomerRepository repository;

    public JpaCustomerRepositoryAdapter(JpaCustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<CustomerEntity> findById(UUID id) {
        repository.findById(id);
        return Optional.empty();
    }

    @Override
    public List<CustomerEntity> findAll() {
        return null;
    }

    @Override
    public Optional<CustomerEntity> findByCompanyEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return null;
    }

    @Override
    public Optional<CustomerEntity> findDni(String dni) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerEntity> findPhone(int phone) {
        return Optional.empty();
    }
}
