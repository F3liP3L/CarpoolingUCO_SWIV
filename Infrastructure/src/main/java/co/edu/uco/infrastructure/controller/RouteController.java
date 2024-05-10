package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.RouteDTO;
import co.edu.uco.application.dto.requestroute.RouteRequestDTO;
import co.edu.uco.application.facade.route.RegisterRouteUseCaseFacade;
import co.edu.uco.application.facade.route.RequestRouteUseCaseFacade;
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

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RequestMapping("api/v1/carpooling-uco/route")
@RestController
public class RouteController {

    @Autowired
    private RequestRouteUseCaseFacade requestRouteFacade;

    @Autowired
    private RegisterRouteUseCaseFacade registerRouteUseCaseFacade;

    @PostMapping()
        public ResponseEntity<Response<RouteDTO>> create(@RequestBody RouteRequestDTO route){
        Response<RouteDTO> response = new Response<>();
        ResponseEntity<Response<RouteDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            response.addData(requestRouteFacade.execute(route));
            response.addMessage(Message.createSuccessMessage("The route has been successfully create.", "successful route create"));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Route"));
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

    @PostMapping("/routes")
    public ResponseEntity<Response<RouteDTO>> register(@RequestBody RouteDTO route){
        Response<RouteDTO> response = new Response<>();
        ResponseEntity<Response<RouteDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            registerRouteUseCaseFacade.execute(route);
            response.addData(route);
            response.addMessage(Message.createSuccessMessage("The route has been successfully create.", "successful route create"));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error register a Route"));
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

}

