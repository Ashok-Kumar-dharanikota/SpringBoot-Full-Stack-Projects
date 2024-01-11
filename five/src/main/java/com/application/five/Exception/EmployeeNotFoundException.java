package com.application.five.Exception;

public class EmployeeNotFoundException extends RuntimeException {
    private String message;

    public EmployeeNotFoundException(String message) {
        this.message = message;
    }
}
