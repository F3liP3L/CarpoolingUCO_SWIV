package co.edu.uco.application.facade.driver.impl;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.facade.driver.ListAllDriverUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.ListAllDriverUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAllDriverUseCaseFacadeImpl implements ListAllDriverUseCaseFacade {

    private final ListAllDriverUseCase listAllDriverUseCase;
    private final DTOAssembler<DriverDTO, DriverEntity> dtoAssembler;

    public ListAllDriverUseCaseFacadeImpl(ListAllDriverUseCase listAllDriverUseCase, DTOAssembler<DriverDTO, DriverEntity> dtoAssembler) {
        this.listAllDriverUseCase = listAllDriverUseCase;
        this.dtoAssembler = dtoAssembler;
    }

    @Override
    public List<DriverDTO> execute(Optional<DriverDTO> param) {
        return listAllDriverUseCase.execute(Optional.of(DriverEntity.createNewDriver())).stream().map(dtoAssembler::assembleDTO).toList();
    }
}
