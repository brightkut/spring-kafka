package com.brightkut.springbootkafka.service;

import com.brightkut.springbootkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String , String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        this.kafkaTemplate.send("test",message);
        LOGGER.info("Message sent {}", message);
    }

    public void sendJsonMessage(User user){

        LOGGER.info("Message sent {}", user.toString());
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "test_json")
                .build();

        kafkaTemplate.send(message);
    }
}
