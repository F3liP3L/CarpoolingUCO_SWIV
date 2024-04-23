package co.edu.uco.application.mapper.dtoassembler;

public interface DTOAssembler<T,D> {
    D assembleDomain(T dto);
    T assembleDTO(D domain);
}
