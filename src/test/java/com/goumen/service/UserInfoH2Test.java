package com.goumen.service;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.goumen.BaseTest;
import com.goumen.xiwan.dao.CreditOrderMapper;
import com.goumen.xiwan.dao.UserInfoMapper;
import com.goumen.xiwan.service.BookInfoService;
import com.goumen.xiwan.service.CreditOrderService;
import com.goumen.xiwan.service.OtherOpertion;
import com.goumen.xiwan.service.UserInfoService;
import com.goumen.xiwan.utils.ReflectionField;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;

//h2与spring，mock整合
public class UserInfoH2Test extends BaseTest {

    @InjectMocks
    private UserInfoService userInfoService;

    @Autowired
    private CreditOrderService creditOrderService;

    @Mock
    private OtherOpertion otherOpertion;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CreditOrderMapper creditOrderMapper;

    //用于多层嵌套
    @Before
    public void before() throws Exception {
        super.setUp();
        ReflectionField.setProperty(userInfoService, "creditOrderService", creditOrderService);
        ReflectionField.setProperty(creditOrderService,"creditOrderMapper",creditOrderMapper);
        ReflectionField.setProperty(creditOrderService,"otherOpertion",otherOpertion);

    }

    //这里是h2和spring的情况
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:META-INF-TEST/data/userInfo.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE,
            value = {"classpath:META-INF-TEST/data/table.xml"})
    public void testH2(){
        System.out.println(userInfoMapper.selectByPrimaryKey(1));
    }


    //h2,mock,spring
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:META-INF-TEST/data/creditOrder.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE,
            value = {"classpath:META-INF-TEST/data/table.xml"})
    public void testGetBookInfo(){
        PowerMockito.when(otherOpertion.getCustomerId(Matchers.anyInt())).thenReturn(1);
        System.out.println(userInfoService.getCreditOrder(1));
    }

}
