package com.mayank.kafkaFirst.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TestJsonTopicConfig {

    @Bean
    public NewTopic newJsonTopic(){
        return TopicBuilder
                .name("TestJson")
                .build();
    }

}
