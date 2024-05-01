package com.bugfi.employeemanagementsystem.Controllers;

import com.bugfi.employeemanagementsystem.Services.IRoleServices;
import com.bugfi.employeemanagementsystem.Services.RoleService;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.bugfi.employeemanagementsystem.Services.IRoleServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RoleController {
    private IRoleServices services;
    public RoleController(IRoleServices services){
        this.services = services;
    }

    @PostMapping("/role/assaign")
    public void assaignRole(@RequestBody Admin admin, @RequestBody Employee employee,@RequestBody Role role){
        services.assaignRole(employee,admin,role);
    }

    @PostMapping("/role/change")
    public void changeRole(@RequestBody Admin admin,@RequestBody Employee employee,@RequestBody Role role){
        services.changeRole(employee,admin,role);
    }
}
