package co.edu.uco.application.mapper.dtoassembler.impl;

import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverPerVehicleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverPerVehicleDTOAssembler implements DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleEntity> {
    private final ModelMapper modelMapper;

    public DriverPerVehicleDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DriverPerVehicleEntity assembleDomain(DriverPerVehicleDTO dto) {
        return modelMapper.map(dto, DriverPerVehicleEntity.class);
    }

    @Override
    public DriverPerVehicleDTO assembleDTO(DriverPerVehicleEntity domain) {
        return modelMapper.map(domain, DriverPerVehicleDTO.class);
    }

}
