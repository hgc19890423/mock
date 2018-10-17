package com.goumen.powermock;

import com.goumen.xiwan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;

//mock private 方法
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class MockingPrivateMethod {
    @Test
    public void testExist() {
        try {
            EmployeeService employeeService = PowerMockito.spy(new EmployeeService());
            PowerMockito.doNothing().when(employeeService, "checkExist", "wangwenjun");
            boolean result = employeeService.exist("wangwenjun");
            assertTrue(result);
            PowerMockito.verifyPrivate(employeeService).invoke("checkExist", "wangwenjun");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}