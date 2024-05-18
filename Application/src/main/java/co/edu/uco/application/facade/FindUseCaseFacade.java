package co.edu.uco.application.facade;

public interface FindUseCaseFacade<D,P> {
    D execute(P param);
}
