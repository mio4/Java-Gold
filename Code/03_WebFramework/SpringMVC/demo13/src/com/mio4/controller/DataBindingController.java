package com.mio4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataBindingController {
    private static final Log Logger = LogFactory.getLog(DataBindingController.class);

    //测试pathVariable注解
    @RequestMapping(value = "/pathVariableTest/{userId}")
    public void pathVariableTest(@PathVariable Integer userId){
        Logger.info("通过pathVariable获取参数：" + userId);
        System.out.println("pathVariable!");
    }

    //测试requestHeader注解
    @RequestMapping(value = "/requestHeaderTest")
    public void requestHeaderTest(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader(value = "Accept")  String[] accepts){
        Logger.info("通过RequestHeader获取参数：" + userAgent);
        for(String a : accepts)
            Logger.info(a);
    }

    //测试CookieValue注解
    @RequestMapping(value = "/cookieValueTest")
    public void cookieValueTest(@CookieValue(value = "JESSIONID",defaultValue="") String sessionId){
        Logger.info("通过cookieValue获取参数：" + sessionId);
    }
}
