package com.bugfi.employeemanagementsystem.dtos;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;
import com.bugfi.employeemanagementsystem.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {
    private Admin admin;
    private Long id;
    private String name;
    private String email;
    private Department department;
    private Role role;
    private Date dateOfJoining;
}
