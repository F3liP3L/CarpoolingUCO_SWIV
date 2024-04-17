package co.edu.uco.application.mapper.dtoassembler.impl;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverDTOAssembler implements DTOAssembler<DriverDTO, DriverEntity> {
    private final ModelMapper modelMapper;

    public DriverDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DriverEntity assembleDomain(DriverDTO dto) {
        return modelMapper.map(dto, DriverEntity.class);
    }

    @Override
    public DriverDTO assembleDTO(DriverEntity domain) {
        return modelMapper.map(domain, DriverDTO.class);
    }
}
