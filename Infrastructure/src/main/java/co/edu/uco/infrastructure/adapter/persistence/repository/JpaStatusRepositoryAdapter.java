package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.StatusEntity;
import co.edu.uco.port.output.repository.StatusRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaStatusRepositoryAdapter implements StatusRepository {

    private final EntityAssembler entityAssembler;
    private final JpaStatusRepository repository;

    public JpaStatusRepositoryAdapter(EntityAssembler entityAssembler, JpaStatusRepository repository) {
        this.entityAssembler = entityAssembler;
        this.repository = repository;
    }

    @Override
    public StatusEntity findByStatus(String status) {
        return entityAssembler.assembleDomain(repository.findByStatus(status), StatusEntity.class);
    }
}
