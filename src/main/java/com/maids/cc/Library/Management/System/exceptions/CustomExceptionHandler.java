package com.maids.cc.Library.Management.System.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Order(1)
public class CustomExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Map<String , Object>> validateException(MethodArgumentNotValidException exception) {
        List<ObjectError> objectErrors = exception.getBindingResult().getAllErrors() ;
        Map<String , Object> response = new LinkedHashMap<>() ;

        List<String> errors = objectErrors
                .stream()
                .map(error -> error.getDefaultMessage()).collect(Collectors.toList());

        response.put("status" , HttpStatus.BAD_REQUEST.value());
        response.put("Validation errors" , errors) ;

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String , Object>> validateException(BadRequestException exception) {
        Map<String , Object> response = new LinkedHashMap<>() ;
        response.put("status" , HttpStatus.BAD_REQUEST.value());
        response.put("message" , exception.getMessage()) ;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String , Object>> badCredentialsException(BadCredentialsException exception) {
        Map<String , Object> response = new LinkedHashMap<>() ;
        response.put("status" , HttpStatus.BAD_REQUEST.value());
        response.put("message" , exception.getMessage()) ;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String , Object>> badCredentialsException(NotFoundCustomException exception) {
        Map<String , Object> response = new LinkedHashMap<>() ;
        response.put("status" , HttpStatus.NOT_FOUND.value());
        response.put("message" , exception.getMessage()) ;
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

}
