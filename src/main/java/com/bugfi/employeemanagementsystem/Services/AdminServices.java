package com.bugfi.employeemanagementsystem.Services;

import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.repository.AdminRepository;

public class AdminServices implements IAdminServices{
    private AdminRepository adminRepository;
    @Override
    public void addAdmin(Admin admin) {
        Admin a = adminRepository.save(admin);
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return (Admin)adminRepository.findByUsername(admin.getUsername());
    }

}
