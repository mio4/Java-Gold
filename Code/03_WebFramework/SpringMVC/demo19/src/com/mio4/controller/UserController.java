package com.mio4.controller;

import com.mio4.pojo.User;
import com.mio4.validator.UserValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    //注入userValidator对象
    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;
    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/loginForm")
    public String toLoginForm(User user2){
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user,
                        Model model,
                        Errors errors){
        logger.info(user);
        model.addAttribute("user",user);
        userValidator.validate(user,errors);
        if(errors.hasErrors()){
            return "loginForm";
        }

        return "success";
    }

}
