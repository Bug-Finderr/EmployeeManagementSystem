package com.bugfi.employeemanagementsystem.Controllers;

import com.bugfi.employeemanagementsystem.models.Admin;
import org.springframework.stereotype.Service;
import com.bugfi.employeemanagementsystem.services.IAdminServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class AdminController {

    private IAdminServices services;

    public AdminController(IAdminServices services){
        this.services = services;
    }

    @PostMapping("/admin/add")
    public void addAdmin(@RequestBody Admin admin){
        services.addAdmin(admin);
    }

    @GetMapping("/admin/get")
    public void getAdmin(@RequestBody Admin admin){
         services.getAdmin(admin);

    }

}
