package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.infrastructure.adapter.persistence.RouteSelectedData;
import co.edu.uco.port.output.repository.RouteSelectedRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaRouteSelectedRepositoryAdapter implements RouteSelectedRepository {

    private final JpaRouteSelectedRepository repository;
    private final EntityAssembler entityAssembler;

    public JpaRouteSelectedRepositoryAdapter(JpaRouteSelectedRepository repository, EntityAssembler entityAssembler) {
        this.repository = repository;
        this.entityAssembler = entityAssembler;
    }

    @Override
    public void save(RouteSelectedEntity route) {
        repository.save(entityAssembler.assembleEntity(route, RouteSelectedData.class));
    }

    @Override
    public Optional<RouteSelectedEntity> findById(UUID id) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findById(id), RouteSelectedEntity.class));
    }

    @Override
    public Optional<RouteSelectedEntity> findByRouteId(UUID routeId) {
        return Optional.ofNullable(entityAssembler.assembleEntity(repository.findByRouteId(routeId), RouteSelectedEntity.class));
    }

    @Override
    public List<RouteSelectedEntity> findAllRouteById(UUID routeId) {
        return repository.findAllByRouteId(routeId).stream().map(elem -> entityAssembler.assembleEntity(elem, RouteSelectedEntity.class)).toList();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
