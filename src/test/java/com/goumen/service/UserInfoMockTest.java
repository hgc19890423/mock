package com.goumen.service;

import com.goumen.xiwan.dao.CreditOrderMapper;
import com.goumen.xiwan.dao.UserInfoMapper;
import com.goumen.xiwan.entity.CreditOrder;
import com.goumen.xiwan.entity.UserInfo;
import com.goumen.xiwan.service.CreditOrderService;
import com.goumen.xiwan.service.OtherOpertion;
import com.goumen.xiwan.service.UserInfoService;
import com.goumen.xiwan.utils.ReflectionField;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Date;

//没有和spring 整合的powermock测试
/*
当使用PowerMockito.whenNew方法时，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是需要mock的new对象代码所在的类。


当需要mock final方法的时候，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是final方法所在的类。


当需要mock静态方法的时候，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是静态方法所在的类。


当需要mock私有方法的时候, 只是需要加注解@PrepareForTest，注解里写的类是私有方法所在的类


当需要mock系统类的静态方法的时候，必须加注解@PrepareForTest和@RunWith。注解里写的类是需要调用系统方法所在的类
*/


@RunWith(PowerMockRunner.class)
public class UserInfoMockTest {

    @InjectMocks
    private UserInfoService userInfoService;

    //用于多级调用
    @InjectMocks
    private CreditOrderService creditOrderService;

    @Mock
    private CreditOrderMapper creditOrderMapper;

    @Mock
    private UserInfoMapper  userInfoMapper;

    @Mock
    private OtherOpertion otherOpertion;

    @Before
    public void setUp() throws Exception {
        //这俩个工具都可以使用，一个是spring的。一个是自己的
        //ReflectionTestUtils.setField(userInfoService, "creditOrderService", creditOrderService);
        ReflectionField.setProperty(userInfoService, "creditOrderService", creditOrderService);
    }

    //这里是一级调用的mock
    @Test
    public void selectBy(){
        UserInfo userInfo=new UserInfo();
        userInfo.setCity("1");
        userInfo.setCreateTime(new Date());
        userInfo.setCustomerId(1);
        userInfo.setGender(Byte.parseByte("1"));
        userInfo.setId(1);
        userInfo.setUpdateTime(new Date());
        userInfoService.selectByPrimaryKey(1);
        PowerMockito.when(userInfoMapper.selectByPrimaryKey(Matchers.anyInt())).thenReturn(userInfo);
        System.out.println(userInfo);
    }

    //这里要测的是多级注入的情况
    @Test
    public void testCredit(){
        CreditOrder creditOrder=new CreditOrder();
        creditOrder.setBookId(1);
        creditOrder.setCreateTime(new Date());
        creditOrder.setCustomerId(1);
        creditOrder.setId(1);
        creditOrder.setOrderId(1231);
        creditOrder.setOrderState(Byte.parseByte("1"));
        creditOrder.setUpdateTime(new Date());
        PowerMockito.when(otherOpertion.getCustomerId(Matchers.anyInt())).thenReturn(1);
        PowerMockito.when(creditOrderMapper.selectByCustomerId(Matchers.anyInt())).thenReturn(creditOrder);
        CreditOrder creditOrder1 = userInfoService.getCreditOrder(1);
        System.out.println(creditOrder1);
    }


}
