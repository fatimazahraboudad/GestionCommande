package com.project.users_service.exception;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException() {
        super(ExceptionMessages.USER_ALREADY_EXIST);
    }
}
