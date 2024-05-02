package com.bugfi.employeemanagementsystem.services.employee;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import java.util.*;
public interface IEmployeeServices {
    List<Employee> getAllEmployees();

    Optional<Employee> getEmployee(Long id) throws EmployeeNotFoundException;

    Employee addEmployee(Admin a, Employee e) throws AdminNotFoundException;

    Employee updateEmployee(Long id, Employee emp, Admin admin) throws EmployeeNotFoundException, AdminNotFoundException;

    Employee selfUpdateEmployee(Employee employee) throws EmployeeNotFoundException;

    void deleteAllEmployees(Admin admin) throws AdminNotFoundException;

    void deleteEmployeeByID(Long id, Admin admin) throws EmployeeNotFoundException, AdminNotFoundException;

}
