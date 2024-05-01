package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByEmail(String name);

}
