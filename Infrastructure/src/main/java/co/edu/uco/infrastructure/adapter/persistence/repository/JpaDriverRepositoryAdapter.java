package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.output.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JpaDriverRepositoryAdapter implements DriverRepository {

    @Autowired
    private JpaDriverRepository repository;

    @Override
    public void save(DriverEntity driverEntity) {
        //driverRepositoryPostgresSQL.save(driverEntity);
    }

    @Override
    public Optional<DriverEntity> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<DriverEntity> getDriverByCustomer(UUID idCustomer) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<DriverEntity> findAllDriver() {
        return List.of();
    }
}
