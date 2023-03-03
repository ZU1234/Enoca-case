package com.enoca.enocacase.controller.advice;

import com.enoca.enocacase.exception.CompanyDoesNotException;
import com.enoca.enocacase.exception.EmployeeDoesNotException;
import com.enoca.enocacase.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CompanyDoesNotException.class)
    public ResponseEntity<ExceptionResponse> handle(CompanyDoesNotException exception) {
        return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(EmployeeDoesNotException.class)
    public ResponseEntity<ExceptionResponse> handleEmployee(EmployeeDoesNotException exception) {
        return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
