package com.bugfi.employeemanagementsystem.services.role;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.RoleNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Role;
import com.bugfi.employeemanagementsystem.repository.RoleRepository;
import com.bugfi.employeemanagementsystem.services.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("roleService")
@AllArgsConstructor
public class RoleService implements IRoleServices {
    private RoleRepository roleRepository;
    private AdminService adminService;


    @Override
    public Role addRole(Role role, Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role, Admin admin) throws AdminNotFoundException, RoleNotFoundException {
        verifyAdmin(admin);
        Role existingRole = roleRepository.findById(role.getId()).orElseThrow(() -> new RoleNotFoundException("Role not found", role.getId().toString()));
        existingRole.setName(role.getName());
        return roleRepository.save(existingRole);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void deleteRoleById(Long id, Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        roleRepository.deleteById(id);
    }

    @Override
    public void deleteAllRoles(Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        roleRepository.deleteAll();
    }

    public void verifyAdmin(Admin admin) throws AdminNotFoundException {
        if (!adminService.verifyAdmin(admin)) {
            throw new AdminNotFoundException("Admin not found", admin.getUsername());
        }
    }
}
