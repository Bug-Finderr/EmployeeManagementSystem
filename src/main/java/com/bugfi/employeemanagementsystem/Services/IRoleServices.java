package com.bugfi.employeemanagementsystem.services;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;

public interface IRoleServices {
    void assignRole(Employee employee, Admin admin, Role role);
    void changeRole(Employee employee, Admin admin, Role role);
    void getEmployeesByRole(Role role);

}
