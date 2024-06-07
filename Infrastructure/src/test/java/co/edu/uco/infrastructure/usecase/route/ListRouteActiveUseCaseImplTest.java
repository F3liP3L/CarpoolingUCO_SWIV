package co.edu.uco.infrastructure.usecase.route;

import co.edu.uco.application.usecase.route.ListRouteActiveUseCaseImpl;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class ListRouteActiveUseCaseImplTest {

    RouteEntity routeEntity = RouteEntity.build();
    DriverPerVehicleEntity driverPerVehicle = DriverPerVehicleEntity.build();
    PositionEntity positionEntity = PositionEntity.build();
    StatusEntity statusEntity = StatusEntity.build();
    LocalDateTime localDate = LocalDateTime.now();

    @Mock
    RouteRepository routeRepository;

    @InjectMocks
    ListRouteActiveUseCaseImpl listRouteActiveUseCaseImpl;

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
    void execute() {
        Mockito.when(routeRepository.findRouteActive()).thenReturn(List.of(routeEntity));

        listRouteActiveUseCaseImpl.execute(Optional.of(routeEntity));
        assertEquals(List.of(routeEntity), listRouteActiveUseCaseImpl.execute(Optional.of(routeEntity)));
        assertFalse(listRouteActiveUseCaseImpl.execute(Optional.of(routeEntity)).isEmpty());
        assertEquals(1, listRouteActiveUseCaseImpl.execute(Optional.of(routeEntity)).size());
    }

}
