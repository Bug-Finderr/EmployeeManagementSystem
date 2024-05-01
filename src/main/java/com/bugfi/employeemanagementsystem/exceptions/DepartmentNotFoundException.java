package com.bugfi.employeemanagementsystem.exceptions;

public class DepartmentNotFoundException extends Exception {
    public String name;

    public DepartmentNotFoundException(String name ,String message) {
        super(message);
        this.name = name;
    }
}
