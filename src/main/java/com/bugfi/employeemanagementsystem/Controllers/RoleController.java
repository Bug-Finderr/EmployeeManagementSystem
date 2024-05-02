package com.bugfi.employeemanagementsystem.controllers;

import com.bugfi.employeemanagementsystem.dtos.AdminRoleDto;
import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.RoleNotFoundException;
import com.bugfi.employeemanagementsystem.services.role.IRoleServices;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final IRoleServices services;

    @GetMapping("")
    public List<Role> getAllRoles(){
        return this.services.getAllRoles();
    }

    @GetMapping("{id}")
    public Optional<Role> getEmployeesByRole(@PathVariable("id") Long id) {
        return services.getRoleById(id);
    }

    @PostMapping("")
    public Role addRole(@RequestBody AdminRoleDto adminRoleDto) throws AdminNotFoundException {
        return services.addRole(adminRoleDto.getRole(), adminRoleDto.getAdmin());
    }

    @PatchMapping("")
    public Role updateRole(@RequestBody AdminRoleDto adminRoleDto) throws AdminNotFoundException, RoleNotFoundException {
        return services.updateRole(adminRoleDto.getRole(), adminRoleDto.getAdmin());
    }

    @DeleteMapping("")
    public String deleteAllRoles(@RequestBody Admin admin) throws AdminNotFoundException {
        services.deleteAllRoles(admin);
        return "Successfully deleted all the roles in the database";
    }

    @DeleteMapping("/{id}")
    public String deleteRoleById(@PathVariable("id") Long id, @RequestBody Admin admin) throws AdminNotFoundException {
        services.deleteRoleById(id, admin);
        return "Successfully deleted the role with role id: " + id;
    }
}
