package com.goumen.powermock;


import com.goumen.xiwan.controller.EmployeeController;
import com.goumen.xiwan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


//对传入参数的控制
@RunWith(PowerMockRunner.class)
public class ArgumentsMatcher {

    @Mock
    private EmployeeService employeeService;

    @Test
    public void testGetEmail() {
        when(employeeService.findEmailByUserName(Mockito.argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(Object argument) {
                String arg = (String) argument;
                if (arg.startsWith("wangwenjun") || arg.startsWith("wwj"))
                    return true;
                else
                    throw new RuntimeException();
            }
        }))).thenReturn("wangwenjun@gmail.com");
        try {
            whenNew(EmployeeService.class).withAnyArguments().thenReturn(employeeService);
            EmployeeController controller = new EmployeeController();
            String email = controller.getEmail("wangwnejun");
            assertEquals("wangwenjun@gmail.com", email);
            controller.getEmail("liudehua");

        } catch (Exception e) {

        }
    }
}
