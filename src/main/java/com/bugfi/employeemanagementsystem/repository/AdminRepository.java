package com.bugfi.employeemanagementsystem.repository;

import com.bugfi.employeemanagementsystem.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByUsername(String name);

    @Override
    Admin save(Admin admin);
}
