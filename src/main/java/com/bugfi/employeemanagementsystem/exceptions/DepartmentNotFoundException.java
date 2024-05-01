package com.bugfi.employeemanagementsystem.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    public String name;
    public DepartmentNotFoundException(String name ,String message) {
        super(message);
        this.name = name;
    }
}
