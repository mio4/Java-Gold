package com.mio4.controller;

import com.mio4.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ModelAttribute3Controller {
    private static List<User> userList;

    public ModelAttribute3Controller(){
        super();
        userList = new ArrayList<User>();
        User user1 = new User("admin","123456","管理员");
        User user2 = new User("mio","654321","普通用户");
        userList.add(user1);
        userList.add(user2);
    }

    //模拟用户名和密码是否正确
    public User find(String loginname, String password){
        for(User user : userList){
            if(user.getUsername().equals(loginname) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    //TODO
    //被ModelAttribute修饰的userModel3方法会先于login3方法调用
    @ModelAttribute
    public User userModel3(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password){
        System.out.println("调用了userModel3方法~");
        return find(loginname,password);
    }

    @RequestMapping(value = "/login3")
    public String login3(){
        System.out.println("login3方法被调用!");
        return "result3";
    }
}
