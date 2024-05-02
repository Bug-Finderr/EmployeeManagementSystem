package com.bugfi.employeemanagementsystem.exceptions;

public class EmployeeNotFoundException extends Exception {
    public String name;

    public EmployeeNotFoundException(String message, String name) {
        super(message);
        this.name = name;
    }
}
