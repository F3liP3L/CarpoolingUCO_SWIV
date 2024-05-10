package co.edu.uco.port.output.repository;

import co.edu.uco.entity.AuthorizedCategoryEntity;
import co.edu.uco.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorizedCategoryRepository {
    Optional<AuthorizedCategoryEntity> findById(UUID id);
    List<AuthorizedCategoryEntity> findAll();
}
