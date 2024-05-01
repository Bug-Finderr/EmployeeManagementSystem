package com.bugfi.employeemanagementsystem.Controllers;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;
import com.bugfi.employeemanagementsystem.services.IDepartmentServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class DepartmentController{

    private IDepartmentServices services;
    public DepartmentController(IDepartmentServices services){
        this.services = services;
    }

    @GetMapping("/departments/getAll")
    public List<Department> getAllDepartments(@RequestBody Admin admin){
        List<Department> departments = this.services.getAllDepartments(admin);
        return departments;
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long id){
        Optional<Department> department = services.getDepartmentById(id);
        return department;
    }

    @PostMapping("/departments/add")
    public void addDepartment(@RequestBody Admin admin,@RequestBody Department department){
        services.addDepartment(department,admin);
        Long id = department.getId();
        System.out.println("Successfully added a new department with department id"+ id);
    }

    @PostMapping("/departments/update")
    public void updateDepartment(@RequestBody Admin admin,@RequestBody Department department){
        Long id = department.getId();
        services.updateDepartment(department,id,admin);
        System.out.println("Succeessfully updated the department with department id "+ id);
    }

    @DeleteMapping("/departments/deleteAll")
    public void deleteAllDepartments(@RequestBody Admin admin){
        services.deleteAllDepartments(admin);
        System.out.println("Successfully delted all the departments");
    }

    @DeleteMapping("/departments/delete/{id}")
    public void deleteDepartmentbyId(@PathVariable("id") Long id,@RequestBody Admin admin){
        services.deleteDepartmentByID(id, admin);
        System.out.println("Successfully deleted the department with id "+id);
    }
}
