package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.output.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaDriverRepositoryAdapter implements DriverRepository {

    @Autowired
    private DriverRepositoryPostgresSQL driverRepositoryPostgresSQL;

    @Override
    public void save(DriverEntity driverEntity) {
        //driverRepositoryPostgresSQL.save(driverEntity);
    }
}
