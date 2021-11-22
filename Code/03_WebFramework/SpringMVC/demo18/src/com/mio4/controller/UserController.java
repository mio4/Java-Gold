package com.mio4.controller;

import com.mio4.pojo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index.html -> /registerForm -> WEB-INF/content/registerForm.html -> /register -> register方法
 */
@Controller
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/{formName}")
    public String registerForm(@PathVariable String formName){
        return formName;
    }

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute User user, Model model){
        logger.info(user);
        model.addAttribute("user",user);
        return "success";
    }
}
