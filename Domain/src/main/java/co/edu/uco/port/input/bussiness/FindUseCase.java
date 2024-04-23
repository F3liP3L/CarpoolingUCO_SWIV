package co.edu.uco.port.input.bussiness;

import java.util.Optional;

public interface FindUseCase<D> {
    D execute(Optional<D> domain);
}
