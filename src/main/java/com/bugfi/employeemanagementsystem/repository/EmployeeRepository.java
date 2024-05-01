package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Override
    Employee findById(Long employeeId);

    @Override
    Employee save(Employee employee);

    Object findAll();

    @Modifying
    @Query("DELETE FROM Employee")
    void deleteAll();

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = :employeeId")
    void delete(Long employeeId);

}
