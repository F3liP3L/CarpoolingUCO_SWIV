package co.edu.uco.port.input.bussiness;

public interface FindUseCase<D, T> {
    D execute(T param);
}
