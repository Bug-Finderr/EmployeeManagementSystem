package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findEmployeeById(Long employeeId);

    @Override
    Optional<Employee> save(Employee employee);

    List<Employee> findAll();

    @Modifying
    @Query("DELETE FROM Employee")
    void deleteAll();

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = :employeeId")
    void delete(Long employeeId);

}
