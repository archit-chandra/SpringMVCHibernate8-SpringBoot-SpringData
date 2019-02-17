package com.example.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    // Add an exception handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e) {
        // create CustomerErrorResponse
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
                                                                        e.getMessage(),
                                                                        System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Add an exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception e) {
        // create CustomerErrorResponse
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                                                        e.getMessage(),
                                                                        System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}