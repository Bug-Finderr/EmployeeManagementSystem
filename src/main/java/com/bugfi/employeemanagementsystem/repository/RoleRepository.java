package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
