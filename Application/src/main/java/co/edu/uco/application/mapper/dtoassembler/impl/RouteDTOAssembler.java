package co.edu.uco.application.mapper.dtoassembler.impl;

import co.edu.uco.application.dto.RouteDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteDTOAssembler implements DTOAssembler<RouteDTO, RouteEntity> {
    private final ModelMapper modelMapper;
    public RouteDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RouteEntity assembleDomain(RouteDTO dto) {
        return modelMapper.map(dto, RouteEntity.class);
    }
    @Override
    public RouteDTO assembleDTO(RouteEntity domain) {
        return modelMapper.map(domain, RouteDTO.class);
    }
}
