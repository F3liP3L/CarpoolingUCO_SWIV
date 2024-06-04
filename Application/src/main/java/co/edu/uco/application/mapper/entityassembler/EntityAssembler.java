package co.edu.uco.application.mapper.entityassembler;

public interface EntityAssembler {
    <D, E> D assembleDomain(E entity, Class<D> domainClass);
    <D, E> E assembleEntity(D domain, Class<E> entityClass);
    <E, T> T assembleDTO(E entity, Class<T> dtoClass);
}
