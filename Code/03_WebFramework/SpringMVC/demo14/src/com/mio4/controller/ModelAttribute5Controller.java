package com.mio4.controller;

import com.mio4.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttribute5Controller {

    @ModelAttribute("user")
    public User userModel5(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password){
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        return user;
    }

    @RequestMapping(value = "/login5")
    public String login5(@ModelAttribute("user") User user){
        user.setUsername("管理员");
        return "result5";
    }
}
