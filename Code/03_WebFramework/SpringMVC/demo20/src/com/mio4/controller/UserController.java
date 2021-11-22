package com.mio4.controller;

import com.mio4.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/registerForm",method = RequestMethod.GET)
    public String registerForm(Model model){
        User user = new User("mio","male",22);
        model.addAttribute("command",user);
        return "registerForm";
    }

}
