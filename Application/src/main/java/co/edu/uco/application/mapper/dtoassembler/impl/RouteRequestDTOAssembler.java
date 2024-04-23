package co.edu.uco.application.mapper.dtoassembler.impl;

import co.edu.uco.application.dto.requestroute.RouteRequestDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteRequestEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteRequestDTOAssembler implements DTOAssembler<RouteRequestDTO, RouteRequestEntity> {
    private final ModelMapper modelMapper;

    public RouteRequestDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RouteRequestEntity assembleDomain(RouteRequestDTO dto) {
        return modelMapper.map(dto, RouteRequestEntity.class);
    }
    @Override
    public RouteRequestDTO assembleDTO(RouteRequestEntity domain) {
        return modelMapper.map(domain, RouteRequestDTO.class);
    }
}
