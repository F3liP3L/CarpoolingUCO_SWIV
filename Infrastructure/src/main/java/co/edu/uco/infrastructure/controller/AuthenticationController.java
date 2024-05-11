package co.edu.uco.infrastructure.controller;

import co.edu.uco.entity.model.JwtRequest;
import co.edu.uco.entity.model.JwtResponse;
import co.edu.uco.port.input.jwt.PortAuthentication;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.util.exception.CarpoolingCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/carpooling/auth")
@Slf4j
public class AuthenticationController {
    @Autowired
    private PortAuthentication authenticateAdapter;
    @PostMapping("/signin")
    public ResponseEntity<Response<JwtResponse>> signIn(@RequestBody JwtRequest request) {
        ResponseEntity<Response<JwtResponse>> responseEntity;
        Response<JwtResponse> response = new Response<>();
        response.setData(new ArrayList<>());
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            JwtResponse token = authenticateAdapter.signIn(request);
            response.addData(token);
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.UNAUTHORIZED;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error controller JWT"));
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}
