package com.bugfi.employeemanagementsystem.controllers;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.services.admin.IAdminServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final IAdminServices services;

    @PostMapping("")
    public Admin addAdmin(@RequestBody Admin admin) {
        return services.addAdmin(admin);
    }

    @GetMapping("{id}")
    public Admin getAdminById(@PathVariable("id") Long id) throws AdminNotFoundException {
        return services.getAdminById(id);
    }

    @GetMapping("")
    public List<Admin> getAllAdmins() {
        return services.getAllAdmins();
    }

    @PatchMapping("")
    public Admin updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
        return services.updateAdmin(admin);
    }

    @DeleteMapping("")
    public String deleteAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
        services.deleteAdmin(admin);
        return "Successfully deleted the admin with id: " + admin.getId();
    }
}
