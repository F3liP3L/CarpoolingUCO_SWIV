package co.edu.uco.application.facade.driver.impl;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.facade.driver.DeleteDriverUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.application.usecase.driver.DeleteDriverUseCase;
import co.edu.uco.entity.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDriverUseCaseFacadeImpl implements DeleteDriverUseCaseFacade {

    @Autowired
    private DeleteDriverUseCase deleteDriverUseCase;
    @Autowired
    private DTOAssembler<DriverDTO, DriverEntity> dtoAssembler;

    @Override
    public void execute(DriverDTO dto) {
        DriverEntity driverDomain = dtoAssembler.assembleDomain(dto);
        deleteDriverUseCase.execute(driverDomain);
    }
}
