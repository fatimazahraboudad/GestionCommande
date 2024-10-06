package com.project.products_service.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    PRODUCT_NOT_FOUND("Product with id %s not found."),
    OUPS_SOMETHING_WRONG("Oups something wrong!!.");


    private final String message;



    public String getMessage() {
        return message;
    }

    public String getMessage(String... args) {
        return String.format(message, (Object[]) args);
    }
}
