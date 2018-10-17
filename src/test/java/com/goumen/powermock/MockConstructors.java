package com.goumen.powermock;

import com.goumen.xiwan.dao.EmployeeDao;
import com.goumen.xiwan.entity.Employee;
import com.goumen.xiwan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;


//mock构造函数
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class MockConstructors {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeDao employeeDao;


    @Test
    public void test() throws Exception {
        whenNew(EmployeeDao.class).withArguments(false, EmployeeDao.Dialect.MYSQL).thenReturn(employeeDao);
        Employee employee = new Employee();
        employeeService.createEmployee(employee);
        Mockito.verify(employeeDao).insertEmployeVoid(employee);
    }
}
