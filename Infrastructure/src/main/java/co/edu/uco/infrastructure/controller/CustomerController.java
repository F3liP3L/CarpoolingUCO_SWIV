package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.CustomerDTO;
import co.edu.uco.application.facade.customer.RegisterCustomerUseCaseFacade;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.port.input.bussiness.customer.FindCustomerUseCase;
import co.edu.uco.port.input.bussiness.customer.ListCustomersUseCase;
import co.edu.uco.util.exception.CarpoolingCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

/**
 * @author Juan Felipe Cardona;
 * Email: felipe7u7432@gmail.com
 * @version id: <b>CarpoolingUCO_SWIV/b> 13/4/2024, 21:55
 **/
@RestController
@RequestMapping("api/v1/carpooling-uco/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private RegisterCustomerUseCaseFacade customerUseCase;
    @Autowired
    private FindCustomerUseCase findCustomerUseCase;
    @Autowired
    private ListCustomersUseCase listCustomersUseCase;



    @GetMapping("/{id}")
    public ResponseEntity<Response<CustomerEntity>> getCustomer(@PathVariable("id") UUID customer) {
        Response<CustomerEntity> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(findCustomerUseCase.execute(customer));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping()
    public ResponseEntity<Response<List<CustomerEntity>>> listCustomer() {
        Response<List<CustomerEntity>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listCustomersUseCase.execute(Optional.empty()));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping()
    public ResponseEntity<Response<CustomerDTO>> createCustomer(@RequestBody CustomerDTO customer) {
        Response<CustomerDTO> response = new Response<>();
        ResponseEntity<Response<CustomerDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            customerUseCase.execute(customer);
            response.addData(customer);
            response.addMessage(Message.createSuccessMessage("The customer has been successfully registered.", "Successful customer registration"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Customer"));
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
}
