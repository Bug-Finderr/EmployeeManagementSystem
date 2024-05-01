package com.bugfi.employeemanagementsystem.exceptionhandlers;

import com.bugfi.employeemanagementsystem.dtos.ExceptionDto;
import com.bugfi.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.DepartmentNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.bugfi.employeemanagementsystem.exceptions.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid id " + e.id + " passed");
        dto.setResolution("Employee Not Found");
        return new ResponseEntity<>(dto , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Department: " +  e.name + " does not exist");
        dto.setResolution("Department Not Found");
        return new ResponseEntity<>(dto , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleRoleNotFoundException(RoleNotFoundException e) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage( e.name + " does not exist");
        dto.setResolution("Role Not Found");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleAdimNotFoundException(AdminNotFoundException e) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(e.name + " not found");
        dto.setResolution("Cannot authorise");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
