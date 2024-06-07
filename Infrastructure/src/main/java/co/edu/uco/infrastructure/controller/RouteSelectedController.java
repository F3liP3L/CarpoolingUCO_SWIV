package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.RouteSelectedDTO;
import co.edu.uco.application.facade.routeselected.FindRouteSelectedUseCaseFacade;
import co.edu.uco.application.facade.routeselected.SelectedRouteUseCaseFacade;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RequestMapping("api/v1/carpooling-uco/routeselected")
@RestController
public class RouteSelectedController {

    @Autowired
    private FindRouteSelectedUseCaseFacade findRouteSelectedUseCaseFacade;
    @Autowired
    private SelectedRouteUseCaseFacade selectedRouteUseCase;

    @PostMapping()
    public ResponseEntity<Response<RouteSelectedDTO>> register(@RequestBody RouteSelectedDTO route){
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
}
