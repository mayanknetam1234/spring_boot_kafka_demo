package com.mayank.kafkaFirst.services.producers.imp;

import com.mayank.kafkaFirst.services.producers.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumerImpl implements KafkaConsumer {
    @Override
    @KafkaListener(topics = "Test",groupId = "myGroup")
    public void TestTopicConsumer(String msg) {
        log.info("Consuming a new msg from topic Test, msg:{}", msg);
    }
}
