package com.goumen.xiwan.dao;


import com.goumen.xiwan.entity.Employee;
import org.springframework.stereotype.Repository;

public class EmployeeDao {
    public EmployeeDao(){}

    public EmployeeDao(boolean lazy, Dialect dialect) {
        throw new UnsupportedOperationException();
    }

    public enum Dialect {
        MYSQL,
        ORACLE
    }

    public int getTotal() {
        throw new UnsupportedOperationException();
    }

    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param employee
     */
    public void saveEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }

    public void updateEmploye(Employee employee) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param employee
     * @return
     */
    public long getCount(Employee employee) {
        throw new UnsupportedOperationException();
    }

    public boolean insertEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }

    public void insertEmployeVoid(Employee employee) {
        throw new UnsupportedOperationException();
    }

    public void insertEmploye(Employee employee) {
        throw new UnsupportedOperationException();
    }

}
