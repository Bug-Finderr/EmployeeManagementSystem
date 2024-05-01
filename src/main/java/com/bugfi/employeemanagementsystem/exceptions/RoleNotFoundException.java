package com.bugfi.employeemanagementsystem.exceptions;

public class RoleNotFoundException extends Exception {
    public String name;

    public RoleNotFoundException(String name,String message) {
        super(message);
        this.name = name;
    }
}
