package co.edu.uco.application.facade;

import java.util.Optional;

public interface FindUseCaseFacade <T> {
    T execute(Optional<T> dto);
}
