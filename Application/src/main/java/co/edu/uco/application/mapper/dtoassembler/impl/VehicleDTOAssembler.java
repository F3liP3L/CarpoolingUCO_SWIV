package co.edu.uco.application.mapper.dtoassembler.impl;

import co.edu.uco.application.dto.VehicleDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleDTOAssembler implements DTOAssembler<VehicleDTO, VehicleEntity> {
    private final ModelMapper modelMapper;

    public VehicleDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public VehicleEntity assembleDomain(VehicleDTO dto) {
        return modelMapper.map(dto, VehicleEntity.class);
    }

    @Override
    public VehicleDTO assembleDTO(VehicleEntity domain) {
        return modelMapper.map(domain, VehicleDTO.class);
    }


}
