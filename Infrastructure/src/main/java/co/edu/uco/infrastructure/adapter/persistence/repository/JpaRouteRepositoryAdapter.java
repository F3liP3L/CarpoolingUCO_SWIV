package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.infrastructure.adapter.persistence.RouteData;
import co.edu.uco.port.output.repository.RouteRepository;
import co.edu.uco.util.json.UtilMapperJson;
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
    private final UtilMapperJson mapperJson;

    public JpaRouteRepositoryAdapter(JpaRouteRepository repository, EntityAssembler entityAssembler, UtilMapperJson mapperJson) {
        this.repository = repository;
        this.entityAssembler = entityAssembler;
        this.mapperJson = mapperJson;
    }

    @Override
    public void save(RouteEntity route) {
        RouteData routeData = entityAssembler.assembleDomain(route, RouteData.class);
        Optional<String> response = mapperJson.execute(route.getPositions());
        response.ifPresent(routeData::setPositions);
        Optional<String> origin = mapperJson.execute(route.getPositions().get(0));
        origin.ifPresent(routeData::setOrigin);
        Optional<String> destination = mapperJson.execute(route.getPositions().get(route.getPositions().size()-1));
        destination.ifPresent(routeData::setDestination);
        repository.save(routeData);
    }

    @Override
    public List<RouteEntity> findRouteActive() {
        return repository.findAll().stream().map(elem -> entityAssembler.assembleEntity(elem, RouteEntity.class)).toList();
    }

    @Override
    public Optional<RouteEntity> findById(UUID id) {
        return repository.findById(id).map(elem -> entityAssembler.assembleEntity(elem, RouteEntity.class));
    }
}
