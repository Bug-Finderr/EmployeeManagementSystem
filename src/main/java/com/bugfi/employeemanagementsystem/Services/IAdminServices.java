package com.bugfi.employeemanagementsystem.services;

import com.bugfi.employeemanagementsystem.models.Admin;

public interface IAdminServices {
    void addAdmin(Admin admin);
    Admin getAdmin(Admin admin);
}
