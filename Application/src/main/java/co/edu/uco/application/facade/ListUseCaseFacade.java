package co.edu.uco.application.facade;

import java.util.List;
import java.util.Optional;

public interface ListUseCaseFacade<T> {
    List<T> execute(Optional<T> param);
}
