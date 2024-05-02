package com.bugfi.employeemanagementsystem.exceptions;

public class RoleNotFoundException extends Exception {
    public String name;

    public RoleNotFoundException(String message, String name) {
        super(message);
        this.name = name;
    }
}
