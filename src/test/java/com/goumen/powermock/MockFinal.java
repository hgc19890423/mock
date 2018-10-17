package com.goumen.powermock;

import com.goumen.xiwan.dao.EmployeeFinalDao;
import com.goumen.xiwan.entity.Employee;
import com.goumen.xiwan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//mock final 类
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeFinalDao.class)
public class MockFinal {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeFinalDao employeeFinalDao;

    @Test
    public void test() {
        Employee employee = new Employee();
        PowerMockito.when(employeeFinalDao.insertEmployee(employee)).thenReturn(true);
        //这里的构造函数可有可无
        //EmployeeService employeeService = new EmployeeService(employeeFinalDao);
        employeeService.createEmployeeFinal(employee);
        Mockito.verify(employeeFinalDao).insertEmployee(employee);
    }
}
