package com.bugfi.employeemanagementsystem.controllers;
import com.bugfi.employeemanagementsystem.dtos.AdminDepartmentDto;
import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.DepartmentNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;
import com.bugfi.employeemanagementsystem.services.department.IDepartmentServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController{
    private final IDepartmentServices services;

    @GetMapping("")
    public List<Department> getAllDepartments(){
        return this.services.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return services.getDepartmentById(id);
    }

    @PostMapping("")
    public Department addDepartment(@RequestBody AdminDepartmentDto adminDepartmentDto) throws AdminNotFoundException {
        return services.addDepartment(adminDepartmentDto.getDepartment(), adminDepartmentDto.getAdmin());
    }

    @PatchMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody AdminDepartmentDto adminDepartmentDto) throws DepartmentNotFoundException, AdminNotFoundException {
        return services.updateDepartment(id, adminDepartmentDto.getDepartment(), adminDepartmentDto.getAdmin());
    }

    @DeleteMapping("")
    public String deleteAllDepartments(@RequestBody Admin admin) throws AdminNotFoundException {
        services.deleteAllDepartments(admin);
        return "Successfully deleted all the departments in the database";
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id,@RequestBody Admin admin) throws DepartmentNotFoundException, AdminNotFoundException {
        services.deleteDepartmentByID(id, admin);
        return "Successfully deleted the department with department id: " + id;
    }
}
