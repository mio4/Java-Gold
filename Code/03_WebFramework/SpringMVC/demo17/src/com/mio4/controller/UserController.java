package com.mio4.controller;

import com.mio4.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @RequestMapping(value = "/login")
    public ModelAndView login(
            String loginname,String password,
            ModelAndView modelAndView,
            HttpSession session){

        //模拟数据库操作
        if("mio".equals(loginname) && "123456".equals(password)){
            User user = new User();
            user.setLoginname(loginname);
            user.setUsername("admin");
            user.setPassword(password);
            //先将用户信息添加到session后，再进行跳转，和拦截器配合
            session.setAttribute("user",user);
            //重定向到main请求
            modelAndView.setViewName("redirect:main");
            //modelAndView.setViewName("main");
        } else{
            modelAndView.addObject("message","用户名或密码错误，请重新登录");
            modelAndView.setViewName("loginForm"); //这个和@RequestMapping直接返回String视图名称
        }

        return modelAndView;
    }
}
