package com.mio4.controller;

import com.mio4.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemsController {

    //制定URL到请求方法的映射
    @RequestMapping("/list")
    public ModelAndView itemsList() throws Exception{
        //商品列表
        List<Items> itemList = new ArrayList<>();

        Items items_1 = new Items();
        items_1.setName("联想笔记本_3");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemList.add(items_1);
        itemList.add(items_2);

        //创建modelandView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加model
        modelAndView.addObject("itemList", itemList);
        //添加视图
        //modelAndView.setViewName("/WEB-INF/jsp/itemsList.jsp");
		modelAndView.setViewName("itemsList");
        return modelAndView;
    }
}
