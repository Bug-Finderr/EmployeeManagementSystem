package com.bugfi.employeemanagementsystem.Services;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import java.util.*;
public interface IEmployeeServices {
    List<Employee> getAllEmployees();

    Optional<Employee> getEmployee(Long id);

    void addEmployee(Employee e);

    void updateEmployee(Employee emp, Long id, Admin admin);

    void deleteAllEmployees(Admin admin);

    void deleteEmployeeByID(Long id,Admin admin);

}
