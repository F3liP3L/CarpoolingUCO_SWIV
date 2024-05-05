package co.edu.uco.application.usecase.route;

import co.edu.uco.application.specification.route.ValidRouteRequestSpecification;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.entity.PositionEntity;
import co.edu.uco.entity.RouteEntity;
import co.edu.uco.entity.RouteRequestEntity;
import co.edu.uco.port.input.bussiness.route.RequestRouteUseCase;
import co.edu.uco.port.input.route.RouteServicePort;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestRouteUseCaseImpl implements RequestRouteUseCase {

    private final RouteServicePort routeServicePort;
    private final ValidRouteRequestSpecification specification;
    private final DriverPerVehicleRepository driverVehicleRepository;

    public RequestRouteUseCaseImpl(RouteServicePort routeServicePort, ValidRouteRequestSpecification specification, DriverPerVehicleRepository driverVehicleRepository) {
        this.routeServicePort = routeServicePort;
        this.specification = specification;
        this.driverVehicleRepository = driverVehicleRepository;
    }

    @Override
    public RouteEntity execute(RouteRequestEntity request) {
        specification.isSatisfyBy(request);
        RouteEntity routeEntity = routeServicePort.buildRoute(request.getOrigin(), request.getDestination());
        routeEntity.setRouteCapacity(request.getRouteCapacity());
        routeEntity.setDestination(PositionEntity.build(request.getDestination().getLatitude(), request.getDestination().getLongitude()));
        routeEntity.setOrigin(PositionEntity.build(request.getOrigin().getLatitude(), request.getOrigin().getLongitude()));
        routeEntity.getDriverVehicle().setId(request.getDriverVehicle().getId());

        DriverPerVehicleEntity driverVehicle = driverVehicleRepository.findById(request.getDriverVehicle().getId());
        routeEntity.setDriverVehicle(driverVehicle);
        return routeEntity;
    }

}
