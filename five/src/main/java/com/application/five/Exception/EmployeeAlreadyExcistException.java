package com.application.five.Exception;

public class EmployeeAlreadyExcistException extends RuntimeException {

    private String message;

    public EmployeeAlreadyExcistException(String message) {
        this.message = message;
    }
}
