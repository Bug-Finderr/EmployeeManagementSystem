package com.bugfi.employeemanagementsystem.services.admin;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;

import java.util.List;

public interface IAdminServices {
    Admin addAdmin(Admin admin);

    Admin getAdminById(Long id) throws AdminNotFoundException;

    List<Admin> getAllAdmins();

    Admin updateAdmin(Admin admin) throws AdminNotFoundException;

    void deleteAdmin(Admin admin) throws AdminNotFoundException;

    boolean verifyAdmin(Admin admin);
}
