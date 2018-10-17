package com.goumen.service;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.google.gson.Gson;
import com.goumen.BaseTest;
import com.goumen.xiwan.entity.UserInfo;
import com.goumen.xiwan.service.UserInfoService;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserServiceValidate extends BaseTest {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Before
    public void before() throws Exception {
        super.setUp();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void test(){
        UserInfo userInfo = new UserInfo();
        userInfo.setCustomerId(1);
        try {
           userInfoService.selectUserInfoByCustomerId(userInfo);
       }catch (ConstraintViolationException e){
            System.out.println(e.getConstraintViolations());
        }

    }

    @Test
    public void testGetUserInfo() throws Exception {
        MvcResult result = mockMvc.perform(get("/user/validate").param("user.id","1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("================================");
        System.out.println(result.getHandler());
    }

    @Test
    public void test1(){
        System.out.println(userInfoService.selectByPrimaryKey(1));
    }


}
