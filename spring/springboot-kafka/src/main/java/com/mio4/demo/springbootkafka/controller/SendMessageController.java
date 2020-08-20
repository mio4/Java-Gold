package com.mio4.demo.springbootkafka.controller;

import com.mio4.demo.springbootkafka.service.SendMessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mio4
 * @date 2020-08-20 17:26
 */

@RestController
@AllArgsConstructor
public class SendMessageController {

    @Autowired
    private SendMessageService sendMessageService;


    /**
     * 向"movie_topic"发送消息
     *
     * @param message
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/send/movie/{message}")
    public String sendToMovie(@PathVariable String message){
        sendMessageService.sendToMovie(message);
        return message;
    }


    /**
     * 尝试向未创建的topic发送消息
     * 结论：会自动创建不存在的topic
     * @param message
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/send/sport/{message}")
    public String sendToSport(@PathVariable String message){
        sendMessageService.sendToSport(message);
        return message;
    }
}
