package com.maids.cc.Library.Management.System.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String , Object>> handleException(Exception ex) {

        Map<String , Object> response = new LinkedHashMap<>() ;
        response.put("status" , HttpStatus.BAD_REQUEST.value());
        response.put("message" , ex.getMessage()) ;

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
