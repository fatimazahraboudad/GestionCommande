package com.project.users_service.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    USER_NOT_FOUND("User with id %s not found."),
    USER_ALREADY_EXIST("User already exists with mail %s."),
    OUPS_SOMETHING_WRONG("Oups something wrong!!.");


    private final String message;



    public String getMessage() {
        return message;
    }

    public String getMessage(String... args) {
        return String.format(message, (Object[]) args);
    }
}
