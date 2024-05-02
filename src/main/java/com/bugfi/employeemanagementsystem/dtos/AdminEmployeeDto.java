package com.bugfi.employeemanagementsystem.dtos;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminEmployeeDto {
    private Admin admin;
    private Employee employee;
}
