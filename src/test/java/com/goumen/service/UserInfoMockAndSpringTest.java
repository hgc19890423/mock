package com.goumen.service;

import com.goumen.BaseTest;
import com.goumen.xiwan.dao.CreditOrderMapper;
import com.goumen.xiwan.entity.BookInfo;
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

import java.math.BigDecimal;
import java.util.Date;

//mock与spring整合，当调用链很多时，用这种方式可以满足
public class UserInfoMockAndSpringTest extends BaseTest {

    @InjectMocks
    private UserInfoService userInfoService;

    @Autowired
    private CreditOrderService creditOrderService;

    @Autowired
    private OtherOpertion otherOpertion;

    @Autowired
    private CreditOrderMapper creditOrderMapper;

    @Mock
    private BookInfoService bookInfoService;

    @Before
    public void before() throws Exception {
        super.setUp();
        ReflectionField.setProperty(userInfoService, "creditOrderService", creditOrderService);
        ReflectionField.setProperty(creditOrderService,"creditOrderMapper",creditOrderMapper);
        ReflectionField.setProperty(creditOrderService,"otherOpertion",otherOpertion);
        ReflectionField.setProperty(creditOrderService,"bookInfoService",bookInfoService);
    }

    @Test
    public void testGetBook(){
        BookInfo bookInfo=new BookInfo();
        bookInfo.setAuthor("1");
        bookInfo.setBookId(1);
        bookInfo.setBookName("1");
        bookInfo.setCreateTime(new Date());
        bookInfo.setNumber(1);
        bookInfo.setPress("1");
        bookInfo.setUpdateTime(new Date());
        bookInfo.setPrice(new BigDecimal(1));
        PowerMockito.when(bookInfoService.selectByBookId(Matchers.anyInt())).thenReturn(bookInfo);
        BookInfo bookInfo1 = userInfoService.getBookInfo(1);
        System.out.println(bookInfo1);

    }



}
