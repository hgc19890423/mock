package com.goumen.powermock;

import com.goumen.xiwan.entity.Employee;
import com.goumen.xiwan.service.UserInfoService;
import com.goumen.xiwan.utils.EmployeeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;

//mock 静态方法
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeUtils.class)
public class MockStatic {

    @InjectMocks
    private UserInfoService userInfoService;


    @Test
    public void testGetEmployeeCountWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);
        int count = userInfoService.getEmployeeCount();
        assertEquals(10, count);
    }

    //mock static 没有返回值
    @Test
    public void testCreateEmployeeWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        Employee employee = new Employee();
        PowerMockito.doNothing().when(EmployeeUtils.class);
        userInfoService.createEmployee(employee);
        PowerMockito.verifyStatic();
    }




}
