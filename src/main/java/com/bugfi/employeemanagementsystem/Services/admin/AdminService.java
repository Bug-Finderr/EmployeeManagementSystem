package com.bugfi.employeemanagementsystem.services.admin;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("adminService")
@AllArgsConstructor
public class AdminService implements IAdminServices {
    private AdminRepository adminRepository;

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) throws AdminNotFoundException {
        return adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException("Admin not found", id.toString()));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
        Admin existingAdmin = adminRepository.findById(admin.getId())
            .orElseThrow(() -> new AdminNotFoundException("Admin not found", admin.getId().toString()));
        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdmin(Admin admin) throws AdminNotFoundException {
        adminRepository.delete(admin);
    }

    @Override
    public boolean verifyAdmin(Admin admin) {
        Admin responseAdmin = adminRepository.findByUsername(admin.getUsername());
        return Objects.equals(admin.getUsername(), responseAdmin.getUsername()) && Objects.equals(admin.getPassword(), responseAdmin.getPassword());
    }

}
