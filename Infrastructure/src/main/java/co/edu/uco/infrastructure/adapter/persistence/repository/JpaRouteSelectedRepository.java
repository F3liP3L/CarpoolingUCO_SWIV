package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.infrastructure.adapter.persistence.RouteSelectedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaRouteSelectedRepository extends JpaRepository<RouteSelectedData, UUID> {
    List<RouteSelectedData> findAllByRouteId(UUID routeId);
    Optional<RouteSelectedData> findByRouteId(UUID routeId);
}
