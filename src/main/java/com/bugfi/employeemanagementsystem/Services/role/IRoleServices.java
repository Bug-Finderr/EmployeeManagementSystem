package com.bugfi.employeemanagementsystem.services.role;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.RoleNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.models.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleServices {
    Role addRole(Role role, Admin admin) throws AdminNotFoundException;

    Role updateRole(Role role, Admin admin) throws AdminNotFoundException, RoleNotFoundException;

    List<Role> getAllRoles();

    Optional<Role> getRoleById(Long id);

    void deleteRoleById(Long id, Admin admin) throws AdminNotFoundException;

    void deleteAllRoles(Admin admin) throws AdminNotFoundException;

}
