package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.infrastructure.adapter.persistence.RouteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface JpaRouteRepository extends JpaRepository<RouteData, UUID> {
    List<RouteData> findByRouteTimeAfter(LocalDateTime dateTime);
}
