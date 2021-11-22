package com.mio4.demo.springbootkafka.service;

import com.mio4.demo.springbootkafka.config.KafkaConstants;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author mio4
 * @date 2020-08-20 17:36
 */

/**
 * 消息生产者
 */
@Service
@AllArgsConstructor
public class SendMessageService {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendToMovie(String message){
        kafkaTemplate.send(KafkaConstants.MOVIE_TOPIC,message);
    }

    public void sendToSport(String message) {
        kafkaTemplate.send(KafkaConstants.SPORT_TOPIC,message);
    }
}
