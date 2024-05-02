package com.bugfi.employeemanagementsystem.dtos;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDepartmentDto {
    private Admin admin;
    private Department department;
}
