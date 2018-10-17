package com.goumen.xiwan.controller;


import com.goumen.xiwan.entity.UserInfo;
import com.goumen.xiwan.service.UserInfoService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

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
    public @ResponseBody UserInfo getUser(Integer id) {
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        return userInfo;
    }

    @RequestMapping(value = "/validate")
    public String validate(@Valid @ModelAttribute("user") UserInfo user, BindingResult result) {
        if (result.hasErrors()) {
            return "SignUpForm";
        } else {
            return "Done";
        }
    }


}
