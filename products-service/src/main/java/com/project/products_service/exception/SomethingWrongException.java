package com.project.products_service.exception;

public class SomethingWrongException extends RuntimeException {
    public SomethingWrongException() {
        super(ExceptionMessages.OUPS_SOMETHING_WRONG.getMessage());
    }

}
