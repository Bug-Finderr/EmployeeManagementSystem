package com.bugfi.employeemanagementsystem.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public Long id;
    public EmployeeNotFoundException(Long id,String message) {
        super(message);
        this.id = id;
    }
}
