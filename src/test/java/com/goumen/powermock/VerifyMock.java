package com.goumen.powermock;

import com.goumen.xiwan.dao.EmployeeDao;
import com.goumen.xiwan.entity.Employee;
import com.goumen.xiwan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class VerifyMock {

    @Mock
    private EmployeeDao employeeDao;


    @Test
    public void testSaveOrUpdateCountLessZero() {
        try {
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService employeeService = new EmployeeService();
            employeeService.saveOrUpdate(employee);
            Mockito.verify(employeeDao).saveEmployee(employee);
            Mockito.verify(employeeDao, Mockito.never()).updateEmploye(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveOrUpdateCountMoreThanZero() {
        try {
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(1L);
            EmployeeService employeeService = new EmployeeService();
            employeeService.saveOrUpdate(employee);
            Mockito.verify(employeeDao).updateEmploye(employee);
            Mockito.verify(employeeDao, Mockito.never()).saveEmployee(employee);
        } catch (Exception e) {

        }
    }


     /*
     其他api
    Mockito.verify(employeeDao,Mockito.never()).saveEmployee(employee);
    Mockito.verify(employeeDao,Mockito.atLeastOnce()).saveEmployee(employee);
    Mockito.verify(employeeDao,Mockito.times(1)).saveEmployee(employee);
    Mockito.verify(employeeDao,Mockito.atMost(1)).saveEmployee(employee);
    Mockito.verify(employeeDao,Mockito.atLeast(1)).saveEmployee(employee);
    */

}
