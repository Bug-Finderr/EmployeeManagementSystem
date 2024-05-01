package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(Long employeeId);
}
