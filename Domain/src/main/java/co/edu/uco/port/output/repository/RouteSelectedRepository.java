package co.edu.uco.port.output.repository;

import co.edu.uco.entity.RouteSelectedEntity;

import java.util.Optional;
import java.util.UUID;

public interface RouteSelectedRepository {
    void save(RouteSelectedEntity route);
    Optional<RouteSelectedEntity> findById(UUID id);
    void deleteById(UUID id);
}
