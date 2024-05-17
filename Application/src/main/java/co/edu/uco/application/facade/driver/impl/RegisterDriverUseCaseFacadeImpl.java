package co.edu.uco.application.facade.driver.impl;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.facade.driver.RegisterDriverUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.RegisterDriverUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDriverUseCaseFacadeImpl implements RegisterDriverUseCaseFacade {

    @Autowired
    private RegisterDriverUseCase registerDriverUseCase;

    @Autowired
    private DTOAssembler<DriverDTO, DriverEntity> dtoAssembler;

    @Override
    public void execute(DriverDTO dto) {
        DriverEntity driver = dtoAssembler.assembleDomain(dto);
        registerDriverUseCase.execute(driver);
    }
}
