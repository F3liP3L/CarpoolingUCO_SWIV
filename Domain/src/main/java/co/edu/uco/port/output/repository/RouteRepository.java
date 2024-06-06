package co.edu.uco.port.output.repository;


import co.edu.uco.entity.RouteEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RouteRepository {
    void save(RouteEntity route);
    List<RouteEntity> findRouteActive();
    Optional<RouteEntity> findById(UUID id);
    void deleteById(UUID id);
}
