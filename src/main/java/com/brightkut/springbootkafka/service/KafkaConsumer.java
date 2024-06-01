package com.brightkut.springbootkafka.service;

import com.brightkut.springbootkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "test", groupId = "group1")
    public void consume(String message){
        LOGGER.info("Message received -> {}", message);
    }

    @KafkaListener(topics = "test_json", groupId = "group1")
    public void consumeJson(User user){
        LOGGER.info("Json Message received -> {}", user.toString());
    }
}
