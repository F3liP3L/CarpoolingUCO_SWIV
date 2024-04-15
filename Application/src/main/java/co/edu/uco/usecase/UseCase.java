package co.edu.uco.usecase;

public interface UseCase <D> {
    void execute(D domain);
}
