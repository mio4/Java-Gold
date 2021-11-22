package com.mio4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    /**
     * 跳转页面
     * @param formName
     * @return
     */
    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName){
        return formName;
    }

}
