package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.facade.driverpervehicle.DeleteDriverPerVehicleUseCaseFacade;
import co.edu.uco.application.facade.driverpervehicle.RegisterDriverPerVehicleUseCaseFacade;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.input.bussiness.driverpervehicle.FindDriverPerVehicleUseCase;
import co.edu.uco.port.input.bussiness.driverpervehicle.ListDriverPerVehicleUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.util.exception.CarpoolingCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;


@RestController
@RequestMapping("api/v1/carpooling-uco/driverpervehicle")
@Slf4j
public class DriverPerVehicleController {
    @Autowired
    private RegisterDriverPerVehicleUseCaseFacade registerDriverPerVehicleUseCaseFacade;
    @Autowired
    private DeleteDriverPerVehicleUseCaseFacade deleteDriverPerVehicleUseCaseFacade;
    @Autowired
    private ListDriverPerVehicleUseCase listDriverPerVehicleUseCase;
    @Autowired
    private FindDriverPerVehicleUseCase findDriverPerVehicleUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Response<DriverPerVehicleEntity>> findById(@PathVariable UUID id) {
        Response<DriverPerVehicleEntity> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(findDriverPerVehicleUseCase.execute(id));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "The Unexpected error, try to " +
                    "get driver per vehicle by id"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping()
    public ResponseEntity<Response<List<DriverPerVehicleEntity>>> findAll( ) {
        Response<List<DriverPerVehicleEntity>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listDriverPerVehicleUseCase.execute(Optional.of(DriverPerVehicleEntity.build())));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error, try to " +
                    "get all driver per vehicle"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping()
    public ResponseEntity<Response<DriverPerVehicleDTO>> create(@RequestBody DriverPerVehicleDTO driverPerVehicleDTO) {
        Response<DriverPerVehicleDTO> response = new Response<>();
        ResponseEntity<Response<DriverPerVehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            registerDriverPerVehicleUseCaseFacade.execute(driverPerVehicleDTO);
            response.addData(driverPerVehicleDTO);
            response.addMessage(Message.createSuccessMessage("The driver per vehicle has been successfully registered.", "Successful driver per vehicle registration"));
            log.info(response.toString());

        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a driver per vehicle"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
            log.warn(response.toString());

        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected errors"));
            log.warn(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @DeleteMapping()
    public ResponseEntity<Response<DriverPerVehicleDTO>> delete(@RequestBody DriverPerVehicleDTO driverPerVehicleDTO) {
        Response<DriverPerVehicleDTO> response = new Response<>();
        ResponseEntity<Response<DriverPerVehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            deleteDriverPerVehicleUseCaseFacade.execute(driverPerVehicleDTO);
            response.addMessage(Message.createSuccessMessage("The driver per vehicle was successfully removed", "Driver per vehicle successfully removed"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.NOT_FOUND;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error deleting driver per vehicle"));
            log.warn(response.toString());
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected Error"));
            log.error(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}
