package com.bugfi.employeemanagementsystem.Controllers;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import org.springframework.stereotype.Controller;
import com.bugfi.employeemanagementsystem.Services.IEmployeeServices;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    private IEmployeeServices services;
    public EmployeeController(IEmployeeServices services){
        this.services = services;
    }
    @PostMapping("/employee/addEmployee")
    public void AddEmployee(@RequestBody Employee e){
        services.addEmployee(e);
        Long id = e.getId();
        System.out.println("Successfully added a new Employee with id "+id);
    }

    @PostMapping("/employee/updateEmployee")
    public void updateEmployee(@RequestBody Admin admin, @RequestBody Employee e){
        Long id = e.getId();
        services.updateEmployee(e,id,admin);
        System.out.println("Successfully Updated employee with id "+id);
    }

    @GetMapping("/employee/deleteAllEmployees")
    public void deleteAllEmployees(@RequestBody Admin admin){
        services.deleteAllEmployees(admin);
        System.out.println("Successfully deleted all the employees in the data base");
    }

    @DeleteMapping("/employee/deleteEmployee/{id}")
    public void deleteEmployeeByID(@RequestBody Admin admin, @PathVariable("id") Long id){
        services.deleteEmployeeByID(id, admin);
    }




}
