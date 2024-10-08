package com.project.orders_service.exception;

public class OrderNotExistException extends RuntimeException{
    public OrderNotExistException(String idOrder) {
        super(ExceptionMessages.ORDER_NOT_EXIST.getMessage(idOrder));
    }
}
