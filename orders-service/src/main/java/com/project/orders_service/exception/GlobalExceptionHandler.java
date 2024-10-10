package com.project.orders_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotExistInStock.class)
    public ResponseEntity<String> handleProductNotExistInStock(ProductNotExistInStock ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INSUFFICIENT_STORAGE);
    }

    @ExceptionHandler(OrderNotExistException.class)
    public ResponseEntity<String> handleOrderNotExist(OrderNotExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProductQuantityVerification.class)
    public ResponseEntity<String> handleProductQuantityVerification(ProductQuantityVerification ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SomethingWrongException.class)
    public ResponseEntity<String> handleSomethingWrong(SomethingWrongException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


}
