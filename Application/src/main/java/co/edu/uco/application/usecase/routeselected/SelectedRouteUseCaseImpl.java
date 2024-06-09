package co.edu.uco.application.usecase.routeselected;

import co.edu.uco.application.specification.impl.routeselected.RouteSelectedHasQuotaSpecification;
import co.edu.uco.crosscutting.util.UtilUUID;
import co.edu.uco.entity.RouteSelectedEntity;
import co.edu.uco.port.input.bussiness.route.UpdateRouteCapacityUseCase;
import co.edu.uco.port.input.bussiness.routeselected.SelectedRouteUseCase;
import co.edu.uco.port.output.repository.RouteSelectedRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SelectedRouteUseCaseImpl implements SelectedRouteUseCase {

    private final RouteSelectedRepository routeSelectedRepository;
    private final UpdateRouteCapacityUseCase updateRouteCapacityUseCase;
    private final RouteSelectedHasQuotaSpecification routeSelectedHasQuotaSpecification;

    public SelectedRouteUseCaseImpl(RouteSelectedRepository routeSelectedRepository, UpdateRouteCapacityUseCase updateRouteCapacityUseCase, RouteSelectedHasQuotaSpecification routeSelectedHasQuotaSpecification) {
        this.routeSelectedRepository = routeSelectedRepository;
        this.updateRouteCapacityUseCase = updateRouteCapacityUseCase;
        this.routeSelectedHasQuotaSpecification = routeSelectedHasQuotaSpecification;
    }

    @Override
    public void execute(RouteSelectedEntity domain) {
        domain.setId(UtilUUID.getUtilUUID().getNewUUID());
        updateRouteCapacityUseCase.execute(domain.getRoute());
        routeSelectedHasQuotaSpecification.isSatisfyBy(domain);
        routeSelectedRepository.save(domain);
    }
}
