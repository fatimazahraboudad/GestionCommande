package com.project.products_service.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String idProduct) {
        super(ExceptionMessages.PRODUCT_NOT_FOUND.getMessage(idProduct));
    }
}
