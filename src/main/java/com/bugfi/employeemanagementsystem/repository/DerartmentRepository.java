package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Department;

import java.util.Optional;

public interface DerartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findByName(String name);
}
