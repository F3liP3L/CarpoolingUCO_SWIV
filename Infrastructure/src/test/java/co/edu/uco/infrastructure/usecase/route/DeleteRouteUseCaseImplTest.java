package co.edu.uco.infrastructure.usecase.route;

import co.edu.uco.application.usecase.route.DeleteRouteUseCaseImpl;
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

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
class DeleteRouteUseCaseImplTest {
    UUID uuid = UUID.randomUUID();

    RouteEntity routeEntity = RouteEntity.build();
    DriverPerVehicleEntity driverPerVehicle = DriverPerVehicleEntity.build();
    PositionEntity positionEntity = PositionEntity.build();
    StatusEntity statusEntity = StatusEntity.build();
    LocalDateTime localDate = LocalDateTime.now();


    @Mock
    RouteRepository routeRepository;

    @InjectMocks
    DeleteRouteUseCaseImpl routeUseCase;

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
    void deleteRoute() {
        Mockito.when(routeRepository.findById(uuid)).thenReturn(Optional.ofNullable(routeEntity));

        routeUseCase.execute(uuid);
    }
}
