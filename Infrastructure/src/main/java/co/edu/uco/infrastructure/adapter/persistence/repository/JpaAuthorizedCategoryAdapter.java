package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.AuthorizedCategoryEntity;
import co.edu.uco.port.output.repository.AuthorizedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaAuthorizedCategoryAdapter implements AuthorizedCategoryRepository {

    @Autowired
    private JpaAuthorizedCategory repository;
    @Autowired
    private EntityAssembler entityAssembler;

    @Override
    public Optional<AuthorizedCategoryEntity> findById(UUID id) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findById(id), AuthorizedCategoryEntity.class));
    }

    @Override
    public List<AuthorizedCategoryEntity> findAll() {
        return repository.findAll().stream().map(entity -> entityAssembler.assembleEntity(entity, AuthorizedCategoryEntity.class)).toList();
    }
}
