package co.edu.uco.port.input.bussiness;

public interface FindUseCase<D> {
    D execute(D domain);
}
