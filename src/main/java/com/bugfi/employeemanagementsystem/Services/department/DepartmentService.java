package com.bugfi.employeemanagementsystem.services.department;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.DepartmentNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Department;
import com.bugfi.employeemanagementsystem.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;

import com.bugfi.employeemanagementsystem.services.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("departmentService")
@AllArgsConstructor
public class DepartmentService implements IDepartmentServices {
    private DepartmentRepository departmentRepository;
    AdminService adminService;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department addDepartment(Department d, Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        return departmentRepository.save(d);
    }

    @Override
    public Department updateDepartment(Long id, Department d, Admin admin) throws DepartmentNotFoundException, AdminNotFoundException {
        verifyAdmin(admin);
        Department department = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found", id.toString()));
        department.setName(d.getName());
        department.setDescription(d.getDescription());
        return departmentRepository.save(department);
    }

    @Override
    public void deleteAllDepartments(Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        departmentRepository.deleteAll();
    }

    @Override
    public void deleteDepartmentByID(Long id, Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        departmentRepository.deleteById(id);
    }

    public void verifyAdmin(Admin admin) throws AdminNotFoundException {
        if (!adminService.verifyAdmin(admin)) {
            throw new AdminNotFoundException("Admin not found", admin.getUsername());
        }
    }

}
