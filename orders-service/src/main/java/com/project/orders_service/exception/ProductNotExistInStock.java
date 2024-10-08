package com.project.orders_service.exception;

public class ProductNotExistInStock extends RuntimeException{
    public ProductNotExistInStock() {
        super(ExceptionMessages.PRODUCT_NOT_EXIST_IN_STOCK.getMessage());
    }
}
