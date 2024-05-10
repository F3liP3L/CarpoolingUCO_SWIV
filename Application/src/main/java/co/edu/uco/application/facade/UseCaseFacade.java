package co.edu.uco.application.facade;

public interface UseCaseFacade<D> {
    void execute(D dto);
}
