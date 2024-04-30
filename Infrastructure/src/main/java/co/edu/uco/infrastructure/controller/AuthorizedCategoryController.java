package co.edu.uco.infrastructure.controller;

import co.edu.uco.application.dto.AuthorizedCategoryDTO;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.port.input.bussiness.authorizedcategory.ListAuthorizedCategoryAllUseCase;
import co.edu.uco.port.input.bussiness.authorizedcategory.ListAuthorizedCategoryUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/carpooling/authorizedcategory")
@Slf4j
public class AuthorizedCategoryController {
    /*@Autowired
    private ListAuthorizedCategoryUseCase listAuthorizedCategoryUseCase;
    @Autowired
    private ListAuthorizedCategoryAllUseCase listAuthorizedCategoryAllUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Response<List<AuthorizedCategoryDTO>>> getOneAuthorizedCategory(@PathVariable("id") UUID id) {
        Response<List<AuthorizedCategoryDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listAuthorizedCategoryUseCase.execute(Optional.of(AuthorizedCategoryDTO.create(id))));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping()
    public ResponseEntity<Response<List<AuthorizedCategoryDTO>>> getAllAuthorizedCategory() {
        Response<List<AuthorizedCategoryDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listAuthorizedCategoryAllUseCase.execute(Optional.of(AuthorizedCategoryDTO.createNewAuthorizedCategory())));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }*/
}
