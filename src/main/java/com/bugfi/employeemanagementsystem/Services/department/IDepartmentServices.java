package com.bugfi.employeemanagementsystem.services.department;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.DepartmentNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentServices {
    List<Department> getAllDepartments();

    Optional<Department> getDepartmentById(Long id) throws DepartmentNotFoundException;

    Department addDepartment(Department d,Admin admin) throws AdminNotFoundException;

    Department updateDepartment(Long id, Department d,Admin admin) throws DepartmentNotFoundException, AdminNotFoundException;

    void deleteAllDepartments(Admin admin) throws AdminNotFoundException;

    void deleteDepartmentByID(Long id,Admin admin) throws DepartmentNotFoundException, AdminNotFoundException;

}
