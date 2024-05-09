package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.infrastructure.adapter.persistence.CustomerData;
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

    private final EntityAssembler entityAssembler;

    public JpaCustomerRepositoryAdapter(JpaCustomerRepository repository, EntityAssembler entityAssembler) {
        this.repository = repository;
        this.entityAssembler = entityAssembler;
    }

    @Override
    public Optional<CustomerEntity> findById(UUID id) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findById(id).get(), CustomerEntity.class));
    }

    @Override
    public List<CustomerEntity> findAll() {
        return null;
    }

    @Override
    public Optional<CustomerEntity> findByCompanyEmail(String email) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findCustomerDataByCompanyEmail(email), CustomerEntity.class));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void save(CustomerEntity entity) {
        repository.save(entityAssembler.assembleDomain(entity, CustomerData.class));
    }

    @Override
    public Optional<CustomerEntity> findDni(String dni) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findByDni(dni), CustomerEntity.class));
    }

    @Override
    public Optional<CustomerEntity> findPhone(String phone) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findByPhone(phone), CustomerEntity.class));
    }
}
