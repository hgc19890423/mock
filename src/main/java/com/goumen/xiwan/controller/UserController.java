package com.goumen.xiwan.controller;


import com.goumen.xiwan.entity.UserInfo;
import com.goumen.xiwan.service.UserInfoService;
import com.goumen.xiwan.utils.DateEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

   /* @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new DateEditor());
    }
*/

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public ModelAndView getUserInfo(Integer id) {
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/createSuccess");
        mav.addObject("user", userInfo);
        return mav;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUser(Integer id) {
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        return userInfo;
    }


    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public @ResponseBody
    UserInfo validate(@Valid @RequestBody UserInfo userInfo) {
        return userInfo;
    }
}
