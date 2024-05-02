package com.bugfi.employeemanagementsystem.dtos;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRoleDto {
    private Admin admin;
    private Role role;
}
