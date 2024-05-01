package co.edu.uco.port.input.bussiness;

public interface UseCase <D> {
    void execute(D domain);
}
