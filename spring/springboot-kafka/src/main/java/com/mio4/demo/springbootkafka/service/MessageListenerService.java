package com.mio4.demo.springbootkafka.service;

import com.mio4.demo.springbootkafka.config.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author mio4
 * @date 2020-08-20 17:46
 */

/**
 * 消息消费者：
 *
 * 监听从SendMessageService传输的消息
 */
@Component
public class MessageListenerService {

    /**
     * 监听movie_topic
     * @param data
     */
    @KafkaListener(topics = {KafkaConstants.MOVIE_TOPIC})
    public void listenFromMovieTopic(String data){
        System.out.println("Receive message from movie_topic : " + data);
    }

    @KafkaListener(topics = {KafkaConstants.SPORT_TOPIC})
    public void listenFromSportTopic(String data){
        System.out.println("Receive message from sport_topic : " + data);
    }

}
