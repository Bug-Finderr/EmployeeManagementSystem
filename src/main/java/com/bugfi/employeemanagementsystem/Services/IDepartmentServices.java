package com.bugfi.employeemanagementsystem.services;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentServices {
    List<Department> getAllDepartments(Admin admin);

    Optional<Department> getDepartmentById(Long id);

    void addDepartment(Department d,Admin admin);

    void updateDepartment(Department d, Long id, Admin admin);

    void deleteAllDepartments(Admin admin);

    void deleteDepartmentByID(Long id,Admin admin);

}
