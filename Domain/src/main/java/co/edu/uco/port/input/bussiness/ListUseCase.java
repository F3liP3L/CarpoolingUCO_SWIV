package co.edu.uco.port.input.bussiness;

import java.util.List;
import java.util.Optional;

public interface ListUseCase<D> {
    List<D> execute(Optional<D> domain);

}
