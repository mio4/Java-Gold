package com.mio4.controller;

import com.mio4.domain.User;
import com.mio4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(String loginname, String password,
                              ModelAndView modelAndView,
                              HttpSession httpSession){
        User user = userService.login(loginname,password);
        if(user != null){
            httpSession.setAttribute("user",user);
            modelAndView.setView(new RedirectView("/demo19/main")); //TODO 跳转地址
        }else{
            modelAndView.addObject("message","登录名或密码错误，请重新输入：");
            modelAndView.setViewName("loginForm");
        }
        return modelAndView;
    }
}
