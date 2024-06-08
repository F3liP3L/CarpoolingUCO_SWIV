package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.DriverDTO;
import co.edu.uco.application.dto.RouteSelectedDTO;
import co.edu.uco.application.facade.routeselected.FindRouteSelectedUseCaseFacade;
import co.edu.uco.application.facade.routeselected.ListRouteSelectedUseCaseFacade;
import co.edu.uco.application.facade.routeselected.SelectedRouteUseCaseFacade;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.port.input.bussiness.routeselected.CancelRouteSelectedUseCase;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RequestMapping("api/v1/carpooling-uco/routeselected")
@RestController
public class RouteSelectedController {

    @Autowired
    private FindRouteSelectedUseCaseFacade findRouteSelectedUseCaseFacade;
    @Autowired
    private SelectedRouteUseCaseFacade selectedRouteUseCase;
    @Autowired
    private CancelRouteSelectedUseCase cancelRouteSelectedUseCase;
    @Autowired
    private ListRouteSelectedUseCaseFacade listRouteSelectedUseCaseFacade;

    @PostMapping()
    public ResponseEntity<Response<RouteSelectedDTO>> registerRoute(@RequestBody RouteSelectedDTO route){
        Response<RouteSelectedDTO> response = new Response<>();
        ResponseEntity<Response<RouteSelectedDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            selectedRouteUseCase.execute(route);
            response.addData(route);
            response.addMessage(Message.createSuccessMessage("The route selected has been successfully create.", "successful route selected create"));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error register a Route Selected"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected errors"));
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<RouteSelectedDTO>> getRouteById(@PathVariable("id") UUID id) {
        Response<RouteSelectedDTO> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(findRouteSelectedUseCaseFacade.execute(id));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping("selected/{id}")
    public ResponseEntity<Response<List<RouteSelectedDTO>>> getRouteSelectedById(@PathVariable("id") UUID id) {
        Response<List<RouteSelectedDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listRouteSelectedUseCaseFacade.execute(Optional.empty()));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<DriverDTO>> cancelRouteSelected(@PathVariable UUID id) {
        Response<DriverDTO> response = new Response<>();
        ResponseEntity<Response<DriverDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            cancelRouteSelectedUseCase.execute(id);
            response.addMessage(Message.createSuccessMessage("The was successfully removed", "Route Selected successfully removed"));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.NOT_FOUND;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error deleting Route Selected"));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected Error"));
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}
