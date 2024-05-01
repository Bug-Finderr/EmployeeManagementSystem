package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Override
    Optional<Department> findById(Long id);

    @Override
    Department save(Department department);
}
