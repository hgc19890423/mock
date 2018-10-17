package com.goumen.powermock;

import com.goumen.BaseTest;
import com.goumen.xiwan.controller.EmployeeController;
import com.goumen.xiwan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

//这个可以mock某个方法，假设根据不同入参，返回不用的值
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeController.class)
public class AnswerInterface {

    @Mock
    private EmployeeService employeeService;

    @Test
    public void testGetEmail() throws Exception {
        PowerMockito.when(employeeService.findEmailByUserName(Mockito.anyString())).then(
                new Answer<Object>() {
                    public String answer(InvocationOnMock invocation) {
                        String argument = (String) invocation.getArguments()[0];
                        if ("wangwenjun".equals(argument)) {
                            return "wangwenjun@gmail.com";
                        } else if ("liudehua".equals(argument)) {
                            return "andy@gmail.com";
                        }
                        return argument;
                    }
                }
        );
        PowerMockito.whenNew(EmployeeService.class).withNoArguments().thenReturn(employeeService);
        EmployeeController controller = new EmployeeController();
        String email = controller.getEmail("wangwenjun");
        assertEquals("wangwenjun@gmail.com", email);
        email = controller.getEmail("liudehua");
        assertEquals("andy@gmail.com", email);
        email = controller.getEmail("JackChen");
        assertEquals("JackChen", email);
    }
}

    /*
    * invocation.getArguments();（1）
      invocation.callRealMethod();（2）
      invocation.getMethod();（3）
      invocation.getMock();（4）

（1）获取mock方法中传递的入参
（2）获取是那个真实的方法调用了该mock接口
（3）获取是那个mock方法被调用了
（4）获取被mock之后的对象
    * */
