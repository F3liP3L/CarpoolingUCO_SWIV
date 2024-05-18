package co.edu.uco.application.usecase.route;

import co.edu.uco.port.input.bussiness.route.DeleteRouteUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class DeleteRouteUseCaseImpl implements DeleteRouteUseCase {
    @Override
    public void execute(UUID domain) {

    }
}
