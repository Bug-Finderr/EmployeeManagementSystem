package com.bugfi.employeemanagementsystem.controllers;

import com.bugfi.employeemanagementsystem.dtos.AdminEmployeeDto;
import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.services.employee.IEmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeServices employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id);
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody AdminEmployeeDto adminEmployeeDto) throws AdminNotFoundException {
        return employeeService.addEmployee(adminEmployeeDto.getAdmin(), adminEmployeeDto.getEmployee());
    }

    @PatchMapping("")
    public Employee updateEmployee(@RequestBody AdminEmployeeDto adminEmployeeDto) throws EmployeeNotFoundException, AdminNotFoundException {
        return employeeService.updateEmployee(adminEmployeeDto.getEmployee().getId(), adminEmployeeDto.getEmployee(), adminEmployeeDto.getAdmin());
    }

    // Employees can edit their own details except for role and dept. (mentioned in PRD)
    @PatchMapping("/self")
    public Employee updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
        return employeeService.selfUpdateEmployee(employee);
    }

    @DeleteMapping("")
    public String deleteAllEmployees(@RequestBody Admin admin) throws AdminNotFoundException {
        employeeService.deleteAllEmployees(admin);
        return "Successfully deleted all the employees in the data base";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeByID(@PathVariable("id") Long id, @RequestBody Admin admin) throws EmployeeNotFoundException, AdminNotFoundException {
        employeeService.deleteEmployeeByID(id, admin);
        return "Successfully deleted the employee with id: " + id;
    }
}
