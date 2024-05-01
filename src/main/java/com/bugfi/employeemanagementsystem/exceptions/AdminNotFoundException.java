package com.bugfi.employeemanagementsystem.exceptions;

public class AdminNotFoundException extends RuntimeException {
    public String name;
    public AdminNotFoundException(String name,String message) {
        super(message);
        this.name = name;
    }
}
