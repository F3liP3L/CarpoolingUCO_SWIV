package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.requestroute.RouteRequestDTO;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RequestMapping("api/v1/carpooling-uco/route")
@RestController
public class RouteController {

    @PostMapping()
    public ResponseEntity<Response<RouteRequestDTO>> create(@RequestBody RouteRequestDTO route){
        Response<RouteRequestDTO> response = new Response<>();
        ResponseEntity<Response<RouteRequestDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            response.addData(route);
            response.addMessage(Message.createSuccessMessage("The route has been successfully create.", "successful route create"));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Route"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected errors"));
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}

