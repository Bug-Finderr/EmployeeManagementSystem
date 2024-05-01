package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentId(Long id);

    @Override
    Department save(Department department);

    @Override
    List<Department> findAll();

    @Modifying
    @Query("DELETE FROM Department")
    void deleteAll();

    @Modifying
    @Query("DELETE FROM Department d WHERE d.id = :departemtnId")
    void delete(Long departmentId);
}
