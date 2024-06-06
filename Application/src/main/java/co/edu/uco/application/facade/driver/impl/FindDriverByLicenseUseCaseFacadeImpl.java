package co.edu.uco.application.facade.driver.impl;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.facade.driver.FindDriverByLicenseUseCaseFacade;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driver.FindDriverByLicenseUseCase;
import org.springframework.stereotype.Service;

@Service
public class FindDriverByLicenseUseCaseFacadeImpl implements FindDriverByLicenseUseCaseFacade {

    private final DTOAssembler<DriverDTO, DriverEntity> dtoAssembler;
    private final FindDriverByLicenseUseCase findDriverByLicenseUseCase;

    public FindDriverByLicenseUseCaseFacadeImpl(DTOAssembler<DriverDTO, DriverEntity> dtoAssembler, FindDriverByLicenseUseCase findDriverByLicenseUseCase) {
        this.dtoAssembler = dtoAssembler;
        this.findDriverByLicenseUseCase = findDriverByLicenseUseCase;
    }

    @Override
    public DriverDTO execute(String param) {
        return dtoAssembler.assembleDTO(findDriverByLicenseUseCase.execute(param));
    }
}
