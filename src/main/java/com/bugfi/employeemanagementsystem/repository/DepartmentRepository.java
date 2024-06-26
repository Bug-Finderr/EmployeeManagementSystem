package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
