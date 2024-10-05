package com.project.users_service.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String idUser) {
        super(ExceptionMessages.USER_NOT_FOUND.getMessage(idUser));
    }
}
