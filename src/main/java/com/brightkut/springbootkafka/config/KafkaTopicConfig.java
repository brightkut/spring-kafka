package com.brightkut.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic testTopic(){
        return TopicBuilder.name("test")
                // can use this to specify partition
//                .partitions(10)
                .build();
    }

    @Bean
    public NewTopic testJsonTopic(){
        return TopicBuilder.name("test_json")
                // can use this to specify partition
//                .partitions(10)
                .build();
    }
}
