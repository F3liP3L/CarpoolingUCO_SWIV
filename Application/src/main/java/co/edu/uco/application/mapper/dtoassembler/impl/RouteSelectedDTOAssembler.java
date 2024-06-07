package co.edu.uco.application.mapper.dtoassembler.impl;

import co.edu.uco.application.dto.RouteSelectedDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.RouteSelectedEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteSelectedDTOAssembler implements   DTOAssembler<RouteSelectedDTO, RouteSelectedEntity> {

    private final ModelMapper modelMapper;

    public RouteSelectedDTOAssembler(ModelMapper modelMapper) {this.modelMapper = modelMapper;}

    @Override
    public RouteSelectedEntity assembleDomain(RouteSelectedDTO dto) {
        return modelMapper.map(dto, RouteSelectedEntity.class);
    }

    @Override
    public RouteSelectedDTO assembleDTO(RouteSelectedEntity domain) {
        return modelMapper.map(domain, RouteSelectedDTO.class);
    }
}
