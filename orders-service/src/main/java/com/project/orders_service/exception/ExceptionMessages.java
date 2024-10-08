package com.project.orders_service.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    PRODUCT_NOT_EXIST_IN_STOCK("Product not exist in stock."),
    PRODUCT_QUANTITY_VERIFICATION("quantity of product id %s should be supp a 0"),
    ORDER_NOT_EXIST("Order with id %s not exist");


    private final String message;



    public String getMessage() {
        return message;
    }

    public String getMessage(String... args) {
        return String.format(message, (Object[]) args);
    }
}
