package com.bugfi.employeemanagementsystem.exceptions;

public class RoleNotFoundException extends RuntimeException {
    public String name;
    public RoleNotFoundException(String name,String message) {
        super(message);
        this.name = name;
    }
}
