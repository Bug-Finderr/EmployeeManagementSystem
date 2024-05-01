package com.bugfi.employeemanagementsystem.services;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;
import com.bugfi.employeemanagementsystem.repository.EmployeeRepository;
import com.bugfi.employeemanagementsystem.repository.RoleRepository;

public class RoleService implements IRoleServices {
    private RoleRepository roleRepository;
    private AdminServices adminServices;
    private EmployeeService employeeservice;
    private EmployeeRepository employeeRepository;

    @Override
    public void assignRole(Employee employee, Admin admin, Role role) {
        verifyAdmin(admin);
        employee.getRole().setId(role.getId());
        employee.getRole().setName(role.getName());
        employeeRepository.save(employee);
    }

    @Override
    public void changeRole(Employee employee, Admin admin, Role role) {
        verifyAdmin(admin);
        employee.getRole().setId(role.getId());
        employee.getRole().setName(role.getName());
        employeeRepository.save(employee);
    }

    @Override
    public void getEmployeesByRole(Role role) {
        roleRepository.findById(role.getId());
    }

    public void verifyAdmin(Admin admin) {
        String password = admin.getPassword();
        try {
            Admin verify = adminServices.getAdmin(admin);
            if (!password.equals(verify.getPassword())) {
                throw new AdminNotFoundException("Admin not found", "Invalid password");
            }
        } catch (AdminNotFoundException e) {
            System.out.println("Admin not found: " + e.getMessage());
        }
    }
}
