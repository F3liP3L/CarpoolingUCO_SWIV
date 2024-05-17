package co.edu.uco.application.facade;

import java.util.Optional;

public interface ListUseCaseFacade<T> {
    T execute(Optional<T> dto);
}
