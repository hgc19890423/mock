package com.goumen.powermock;

import com.goumen.xiwan.service.ForNew;
import com.goumen.xiwan.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserInfoService.class)
public class MockLocalVariale {

    @InjectMocks
    private UserInfoService userInfoService;

    @Mock
    private ForNew forNew;

    //mock new对象
    @Test
    public void testNew() throws Exception{
        PowerMockito.whenNew(ForNew.class).withNoArguments()
                .thenReturn(forNew);
        PowerMockito.when(forNew.add()).thenReturn(1);

        int operton = userInfoService.operton();
        System.out.println(operton);
    }

    //mock new 没有返回值
    @Test
    public void testNewNoReturn()throws Exception{
        PowerMockito.whenNew(ForNew.class).withNoArguments()
                .thenReturn(forNew);

        userInfoService.opertionVoid();

        Mockito.verify(forNew).get(1);

    }
}
