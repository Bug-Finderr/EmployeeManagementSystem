package com.bugfi.employeemanagementsystem.services.employee;

import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.bugfi.employeemanagementsystem.models.Admin;
import com.bugfi.employeemanagementsystem.models.Employee;
import com.bugfi.employeemanagementsystem.repository.EmployeeRepository;
import com.bugfi.employeemanagementsystem.services.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeService")
@AllArgsConstructor
public class EmployeeService implements IEmployeeServices {
    private EmployeeRepository employeeRepository;
    private AdminService adminService;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee addEmployee(Admin admin, Employee employee) throws AdminNotFoundException {
        verifyAdmin(admin);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee emp, Admin admin) throws AdminNotFoundException, EmployeeNotFoundException {
        verifyAdmin(admin);
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found", id.toString()));
        if (emp.getName() != null) employee.setName(emp.getName());
        if (emp.getEmail() != null) employee.setEmail(emp.getEmail());
        if (emp.getDepartment() != null) employee.setDepartment(emp.getDepartment());
        if (emp.getRole() != null) employee.setRole(emp.getRole());
        if (emp.getDateOfJoining() != null) employee.setDateOfJoining(emp.getDateOfJoining());
        return employeeRepository.save(employee);
    }

    // Employees can edit their own details except for role and dept. (mentioned in PRD)
    @Override
    public Employee selfUpdateEmployee(Employee employee) throws EmployeeNotFoundException {
        Employee existingEmployee = employeeRepository.findById(employee.getId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found", employee.getId().toString()));
        if (employee.getName() != null) existingEmployee.setName(employee.getName());
        if (employee.getEmail() != null) existingEmployee.setEmail(employee.getEmail());
        if (employee.getDateOfJoining() != null) existingEmployee.setDateOfJoining(employee.getDateOfJoining());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteAllEmployees(Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeByID(Long id, Admin admin) throws AdminNotFoundException {
        verifyAdmin(admin);
        employeeRepository.deleteById(id);
    }


    public void verifyAdmin(Admin admin) throws AdminNotFoundException {
        if (!adminService.verifyAdmin(admin)) {
            throw new AdminNotFoundException("Admin not found", admin.getUsername());
        }
    }
}
