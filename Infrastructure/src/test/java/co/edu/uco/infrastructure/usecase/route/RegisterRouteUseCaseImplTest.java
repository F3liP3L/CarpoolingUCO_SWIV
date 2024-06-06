package co.edu.uco.infrastructure.usecase.route;

import co.edu.uco.application.specification.impl.route.ValidRouteSpecification;
import co.edu.uco.application.usecase.route.RegisterRouteUseCaseImpl;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.entity.PositionEntity;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.entity.StatusEntity;
import co.edu.uco.port.output.repository.RouteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RegisterRouteUseCaseImplTest {

    RouteEntity routeEntity = RouteEntity.build();
    DriverPerVehicleEntity driverPerVehicle = DriverPerVehicleEntity.build();
    PositionEntity positionEntity = PositionEntity.build();
    StatusEntity statusEntity = StatusEntity.build();
    LocalDateTime localDate = LocalDateTime.now();

    @Mock
    RouteRepository routeRepository;

    @Mock
    ValidRouteSpecification validRouteSpecification;

    @InjectMocks
    RegisterRouteUseCaseImpl routeUseCase;

    @BeforeEach
    void setUp() {
        routeEntity.setId(UUID.randomUUID());
        routeEntity.setRouteCapacity(4);
        routeEntity.setDriverVehicle(driverPerVehicle);
        routeEntity.setOrigin(positionEntity);
        routeEntity.setDestination(positionEntity);
        routeEntity.setPositions(List.of(positionEntity));
        routeEntity.setPointOfInterest(List.of("Universidad de Córdoba","Somer","UCO"));
        routeEntity.setRouteTime(localDate);
        routeEntity.setRouteStatus(statusEntity);
    }

    @Test
    void createRoute() {
        Mockito.when(validRouteSpecification.isSatisfyBy(routeEntity)).thenReturn(true);
        routeUseCase.execute(routeEntity);

        Mockito.verify(routeRepository, Mockito.times(1)).save(routeEntity);
    }

    @Test
    void createBadRoute() {
        Mockito.when(validRouteSpecification.isSatisfyBy(routeEntity)).thenReturn(true);
        routeUseCase.execute(routeEntity);

        Mockito.verify(routeRepository, Mockito.times(1)).save(routeEntity);
        assertTrue(routeEntity.getRouteCapacity() <= 4, "The capacity of the vehicle is greater than the capacity of a regular vehicle.");
        assertTrue(routeEntity.getPointOfInterest().size() >= 3, "The number of points of interest is less than the minimum required.");
        assertTrue(routeEntity.getRouteTime().isBefore(LocalDateTime.now().minusHours(1)), "The time of the route is less than the current time.");
    }
}
