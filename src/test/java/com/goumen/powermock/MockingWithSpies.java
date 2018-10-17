package com.goumen.powermock;

import com.goumen.xiwan.service.FileService;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class MockingWithSpies {

    @Test
    public void testWriteSpy()
    {
        FileService fileService = PowerMockito.spy(new FileService());
        fileService.write("liudehua");
        File file = new File(System.getProperty("user.dir")+ "/wangwenjun.txt");
        assertTrue(file.exists());
    }

    /*
    * Spy是一个特别有意思的API，他能让你mock一个对象，并且只mock个别方法的行为，保留对某些方法原始的业务逻辑，根据具体情况选择使用
    * */
}
