package com.bugfi.employeemanagementsystem.Services;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;

public interface IRoleServices {
    void assaignRole(Employee employee, Admin admin, Role role);
    void changeRole(Employee employee, Admin admin, Role role);
    void getEmployeesByRole(Role role);

}
