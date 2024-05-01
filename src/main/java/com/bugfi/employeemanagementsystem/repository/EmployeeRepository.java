package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findEmployeeById(Long employeeId);

    @Override
    Employee save(Employee employee);

    List<Employee> findAll();

    @Modifying
    @Query("DELETE FROM Employee")
    void deleteAll();

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = :employeeId")
    void delete(Long employeeId);

}
