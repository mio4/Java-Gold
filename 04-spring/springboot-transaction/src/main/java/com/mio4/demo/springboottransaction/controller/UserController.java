package com.mio4.demo.springboottransaction.controller;

import com.mio4.demo.springboottransaction.domain.User;
import com.mio4.demo.springboottransaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mio4
 * @date 2020-08-21 09:54
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @RequestMapping(value = "/insert/exception", method = RequestMethod.POST)
    public void insertUserWithException(@RequestBody User user){
        userService.insertUserWithException(user);
    }

}
