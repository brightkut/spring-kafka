package com.brightkut.springbootkafka.controller;

import com.brightkut.springbootkafka.payload.User;
import com.brightkut.springbootkafka.service.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message){
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message was sent to topic");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        kafkaProducer.sendJsonMessage(user);

        return ResponseEntity.ok("Message json was sent to topic");
    }
}
