package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.VehicleDTO;
import co.edu.uco.application.facade.vehicle.FindVehicleUseCaseFacade;
import co.edu.uco.application.facade.vehicle.RegisterVehicleUseCaseFacade;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.port.input.bussiness.vehicle.DeleteVehicleUseCase;
import co.edu.uco.util.exception.CarpoolingCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RestController
@RequestMapping("api/v1/carpooling-uco/vehicle")
@Slf4j
public class VehicleController {
    @Autowired
    private RegisterVehicleUseCaseFacade registerVehicleUseCaseFacade;
    @Autowired
    private DeleteVehicleUseCase deleteVehicleUseCase;
    @Autowired
    private FindVehicleUseCaseFacade findVehicleUseCaseFacade;

    @PostMapping()
    public ResponseEntity<Response<VehicleDTO>> create(@RequestBody VehicleDTO vehicle) {
        Response<VehicleDTO> response = new Response<>();
        ResponseEntity<Response<VehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            registerVehicleUseCaseFacade.execute(vehicle);
            response.addData(vehicle);
            response.addMessage(Message.createSuccessMessage("The vehicle has been successfully registered.", "Successful vehicle registration"));
            log.info(response.toString());

        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Vehicle"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
            log.warn(response.toString());

        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected errors "));
            log.warn(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<VehicleDTO>> getCustomer(@PathVariable("id") UUID id) {
        Response<VehicleDTO> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(findVehicleUseCaseFacade.execute(id));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<VehicleDTO>> delete(@PathVariable UUID id) {
        Response<VehicleDTO> response = new Response<>();
        ResponseEntity<Response<VehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            deleteVehicleUseCase.execute(id);
            response.addMessage(Message.createSuccessMessage("The vehicle was successfully removed", "Vehicle successfully removed"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.NOT_FOUND;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error deleting vehicle"));
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
