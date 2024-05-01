package com.bugfi.employeemanagementsystem.Services;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;

import java.util.List;

public interface IDepartmentServices {
    List<Department> getAllDepartments(Admin admin);

    Department getDepartmentById(Long id);

    void addDepartment(Department d,Admin admin);

    void updateDepartment(Department d, Long id, Admin admin);

    void deleteAllDepartments(Admin admin);

    void deleteDepartmentByID(Long id,Admin admin);

}
