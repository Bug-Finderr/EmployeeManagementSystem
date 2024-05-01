package com.bugfi.employeemanagementsystem.services;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements IEmployeeServices {

    private EmployeeRepository employeeRepository;
    AdminServices adminServices;
    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void addEmployee(Employee e) {
        Employee  emp =  (Employee) employeeRepository.save(e);
    }

    @Override
    public void updateEmployee(Employee emp, Long id, Admin admin) {
        verifyAdmin(admin);
        emp.setId(id);
        Employee e = employeeRepository.save(emp);
    }

    @Override
    public void deleteAllEmployees(Admin admin) {
        verifyAdmin(admin);
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeByID(Long id, Admin admin) {
        verifyAdmin(admin);
        employeeRepository.delete(id);
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
