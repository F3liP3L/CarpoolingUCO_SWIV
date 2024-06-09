package co.edu.uco.port.output.repository;

import co.edu.uco.entity.RouteSelectedEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RouteSelectedRepository {
    void save(RouteSelectedEntity route);
    Optional<RouteSelectedEntity> findById(UUID id);
    Optional<RouteSelectedEntity> findByRouteId(UUID routeId);
    List<RouteSelectedEntity> findAllRouteById(UUID routeId);
    void deleteById(UUID id);
}
