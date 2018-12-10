package com.goumen.xiwan.service;


import com.goumen.xiwan.dao.EmployeeDao;
import com.goumen.xiwan.dao.EmployeeFinalDao;
import com.goumen.xiwan.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class EmployeeService {

    private EmployeeFinalDao employeeFinalDao;

    public EmployeeService() {
    }

    public EmployeeService(EmployeeFinalDao employeeFinalDao) {
        this.employeeFinalDao = employeeFinalDao;
    }

    public void createEmployeeFinal(Employee employee) {
        employeeFinalDao.insertEmployee(employee);
    }

    public void saveOrUpdate(Employee employee) {
        final EmployeeDao employeeDao = new EmployeeDao();
        long count = employeeDao.getCount(employee);
        if (count > 0){
            employeeDao.updateEmploye(employee);
        } else{
            employeeDao.saveEmployee(employee);
        }

    }

    public void createEmployee(final Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao(false, EmployeeDao.Dialect.MYSQL);
        employeeDao.insertEmployeVoid(employee);
    }

    public String findEmailByUserName(String userName) {
        throw new UnsupportedOperationException();
    }

    public boolean exist(String userName) {
        String s = checkExist(userName);
        System.out.println(s);
        return true;
    }
    private String checkExist(String userName)
    {
        throw new UnsupportedOperationException();
    }
}

