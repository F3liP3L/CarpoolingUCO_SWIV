package co.edu.uco.application.mapper.entityassembler.impl;

import co.edu.uco.application.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityAssemblerService implements EntityAssembler {

    private final ModelMapper modelMapper;

    public EntityAssemblerService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <D, E> D assembleDomain(E entity, Class<D> domainClass) {
        return modelMapper.map(entity, domainClass);
    }

    @Override
    public <D, E> E assembleEntity(D domain, Class<E> entityClass) {
        return modelMapper.map(domain, entityClass);
    }

    @Override
    public <E, T> T assembleDTO(E entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}