package com.mio4.demo.springboothbase.controller;

import com.mio4.demo.springboothbase.utils.HbaseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author mio4
 * @date 2020-08-21 11:15
 */
@RestController
public class CrudController {

    /**
     *
     * 创建一张Hbase表，两个Column family
     *
     * @param cf1 column family name_1
     * @param cf2 column family name_2
     */
    @RequestMapping(value = "/create/table/2cf", method = RequestMethod.GET)
    public void createTable(@RequestParam("tb") String tb,
                            @RequestParam("cf1") String cf1,
                            @RequestParam("cf2") String cf2){
        HbaseUtils.createTable(tb, Arrays.asList(cf1,cf2));
    }

    public void insert(){

    }


}
