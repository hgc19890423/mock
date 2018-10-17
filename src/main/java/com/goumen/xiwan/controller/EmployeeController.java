package com.goumen.xiwan.controller;

import com.goumen.xiwan.service.EmployeeService;


public class EmployeeController {
    public String getEmail(final String userName) {
        EmployeeService employeeService = new EmployeeService();
        String email = employeeService.findEmailByUserName(userName);
        return email;
    }
}
