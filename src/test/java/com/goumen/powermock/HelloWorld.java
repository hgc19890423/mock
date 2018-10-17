package com.goumen.powermock;

import com.goumen.xiwan.dao.UserInfoMapper;
import com.goumen.xiwan.entity.UserInfo;
import com.goumen.xiwan.service.OtherOpertion;
import com.goumen.xiwan.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class HelloWorld {

    @InjectMocks
    private UserInfoService userInfoService;

    @Mock
    private UserInfoMapper userInfoMapper;

    @Mock
    private OtherOpertion otherOpertion;

    //测试有返回值
    @Test
    public void test(){
        UserInfo userInfo = new UserInfo();
        userInfo.setCity("包头");
        PowerMockito.when(userInfoMapper.selectByPrimaryKey(Matchers.anyInt())).thenReturn(userInfo);
        UserInfo userInfo1 = userInfoService.selectByPrimaryKey(1);
        System.out.println(userInfo1);

    }

    //测试没有返回值
    @Test
    public void testInsert(){
        PowerMockito.doNothing().when(otherOpertion).add(1);
        userInfoService.add(1);
        Mockito.verify(otherOpertion).add(1);
    }

}
