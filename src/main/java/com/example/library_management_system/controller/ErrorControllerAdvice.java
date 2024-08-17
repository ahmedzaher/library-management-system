package com.example.library_management_system.controller;

import com.example.library_management_system.dto.ApiErrorResponse;
import com.example.library_management_system.exception.BadRequestException;
import com.example.library_management_system.exception.InternalErrorException;
import com.example.library_management_system.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return renderError(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(BadRequestException e) {
        return renderError(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(NotFoundException e) {
        return renderError(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(InternalErrorException e) {
        return renderError(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<ApiErrorResponse> renderError(String e, HttpStatus statusCode) {
        return ResponseEntity.status(statusCode).body(new ApiErrorResponse(statusCode.value(), e));
    }
}
