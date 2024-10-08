package com.project.orders_service.exception;

public class ProductQuantityVerification extends RuntimeException{

    public ProductQuantityVerification(String idProduct){
        super(ExceptionMessages.PRODUCT_QUANTITY_VERIFICATION.getMessage(idProduct));
    }
}
