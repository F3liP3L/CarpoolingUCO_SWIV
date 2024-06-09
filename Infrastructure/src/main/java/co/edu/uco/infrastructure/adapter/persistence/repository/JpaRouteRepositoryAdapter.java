package co.edu.uco.infrastructure.adapter.persistence.repository;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import co.edu.uco.entity.PositionEntity;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.infrastructure.adapter.persistence.RouteData;
import co.edu.uco.port.output.repository.RouteRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import co.edu.uco.util.json.UtilMapperJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
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
        LocalDateTime now = LocalDateTime.now();
        List<RouteData> routes = repository.findAll().stream()
                .filter(route -> route.getRouteTime().plusMinutes(20).isAfter(now)).toList();
        return routes.stream().map(route -> {
            RouteEntity routeAvailable = entityAssembler.assembleEntity(route, RouteEntity.class);
            routeAvailable.setOrigin(mapperJson.execute(route.getOrigin(), PositionEntity.class).get());
            routeAvailable.setDestination(mapperJson.execute(route.getDestination(), PositionEntity.class).get());
            return routeAvailable;
        }).toList();
    }

    @Override
    public Optional<RouteEntity> findById(UUID id) {
        Optional<RouteData> response = repository.findById(id);
        if (response.isPresent()) {
            RouteEntity route = entityAssembler.assembleEntity(response.get(), RouteEntity.class);
            try {
                route.setPositions(mapperJson.execute(response.get().getPositions(), new TypeReference<>() {}));
            } catch (JsonProcessingException exception) {
                throw CarpoolingCustomException.buildTechnicalException(exception.getMessage());
            }
            return Optional.of(route);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
