package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.domain.CustomerDomain;
import co.edu.uco.repository.CustomerRepository;
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
    public Optional<CustomerDomain> findById(UUID id) {
        repository.findById(id);
        return Optional.empty();
    }

    @Override
    public List<CustomerDomain> findAll() {
        return null;
    }

    @Override
    public Optional<CustomerDomain> findByCompanyEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public CustomerDomain save(CustomerDomain entity) {
        return null;
    }

    @Override
    public Optional<CustomerDomain> findDni(String dni) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerDomain> findPhone(int phone) {
        return Optional.empty();
    }
}
