package com.mio4.controller;

import com.mio4.pojo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {
    private static List<User> userList;
    private static final Log Logger = LogFactory.getLog(UserController.class);

    public UserController(){
        super();
        this.userList = new ArrayList<User>();
    }

    //当向URL输入/user/register时是GET请求，所以跳转到registerForm.jsp页面
    @RequestMapping(value="/register" , method = RequestMethod.GET)
    public String registForm(){
        Logger.info("register GET 方法被调用");
        return "registerForm";
    }

    //当点击提交按钮时，也是向访问user/register个资源，但是这一次是POST请求，并且请求中带有参数username... 所以处理之后跳转到loginForm.jsp页面
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(
            @RequestParam("loginname") String loginname,
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        Logger.info("register POST 方法被调用");
        User user = new User();
        user.setLoginname(loginname);
        user.setUsername(username);
        user.setPassword(password);
        userList.add(user); //模拟数据库操作
        return "loginForm";
    }

    @RequestMapping(value="/login")
    public String login(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model){
        Logger.info("登录名："+loginname + "密码：" + password);
        for(User user : userList){
            if(user.getLoginname().equals(loginname) && user.getPassword().equals(password)){
                model.addAttribute("user",user);
                return "welcome";
            }

        }
        return "loginForm";
    }
}
