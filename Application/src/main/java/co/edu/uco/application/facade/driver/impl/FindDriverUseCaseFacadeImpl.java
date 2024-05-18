package co.edu.uco.application.facade.driver.impl;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.facade.driver.FindDriverUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.FindDriverUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindDriverUseCaseFacadeImpl implements FindDriverUseCaseFacade {

    private final FindDriverUseCase findDriverUseCase;
    private final DTOAssembler<DriverDTO, DriverEntity> dtoAssembler;

    public FindDriverUseCaseFacadeImpl(FindDriverUseCase findDriverUseCase, DTOAssembler<DriverDTO, DriverEntity> dtoAssembler) {
        this.findDriverUseCase = findDriverUseCase;
        this.dtoAssembler = dtoAssembler;
    }

    @Override
    public DriverDTO execute(UUID param) {
        return dtoAssembler.assembleDTO(findDriverUseCase.execute(param));
    }
}
