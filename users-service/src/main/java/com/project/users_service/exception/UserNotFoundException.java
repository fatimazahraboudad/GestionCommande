package com.project.users_service.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super(ExceptionMessages.USER_NOT_FOUND);
    }
}
