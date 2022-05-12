package com.codecafe.spring.aop.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderErrorHandler {

  @ExceptionHandler({OrderNotFoundException.class})
  public ResponseEntity<ErrorResponse> handleOrderNotFoundException(Exception ex) {
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
  }

}