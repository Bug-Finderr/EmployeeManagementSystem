package com.bugfi.employeemanagementsystem.Services;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;
import com.bugfi.employeemanagementsystem.Services.IRoleServices;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleServices {
    @Override
    public void assaignRole(Employee employee, Admin admin, Role role) {

    }

    @Override
    public void changeRole(Employee employee, Admin admin, Role role) {

    }

    @Override
    public void getEmployeesByRole(Role role) {

    }
}
