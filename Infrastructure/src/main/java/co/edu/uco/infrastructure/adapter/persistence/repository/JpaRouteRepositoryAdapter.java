package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.infrastructure.adapter.persistence.RouteData;
import co.edu.uco.port.output.repository.RouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Transactional
public class JpaRouteRepositoryAdapter implements RouteRepository {

    private final JpaRouteRepository repository;
    private final EntityAssembler entityAssembler;

    public JpaRouteRepositoryAdapter(JpaRouteRepository repository, EntityAssembler entityAssembler) {
        this.repository = repository;
        this.entityAssembler = entityAssembler;
    }

    @Override
    public void save(RouteEntity route) {
        RouteData routeData = entityAssembler.assembleDomain(route, RouteData.class);
        repository.save(routeData);
    }

    @Override
    public List<RouteEntity> findRouteActive() {
        return repository.findAll().stream().map(elem -> entityAssembler.assembleEntity(elem, RouteEntity.class)).toList();
    }

    @Override
    public Optional<RouteEntity> findByRoute(UUID id) {
        return Optional.empty();
    }
}
