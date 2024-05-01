package co.edu.uco.application.mapper.dtoassembler.impl;

import co.edu.uco.application.dto.CustomerDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOAssembler implements DTOAssembler<CustomerDTO, CustomerEntity> {
    private final ModelMapper modelMapper;

    public CustomerDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerEntity assembleDomain(CustomerDTO dto) {
        return modelMapper.map(dto, CustomerEntity.class);
    }

    @Override
    public CustomerDTO assembleDTO(CustomerEntity domain) {
        return modelMapper.map(domain, CustomerDTO.class);
    }
}
