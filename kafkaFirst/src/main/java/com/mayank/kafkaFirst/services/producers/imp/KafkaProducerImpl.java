package com.mayank.kafkaFirst.services.producers.imp;

import com.mayank.kafkaFirst.services.producers.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class KafkaProducerImpl implements KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topic,String msg) {
        log.info("Sending msg in Test topic:{}", msg);
        kafkaTemplate.send(topic,msg);
    }

    @Override
    public <T> void sendJsonMessage(String topic, T object) {
        Message<T> message= MessageBuilder
                .withPayload(object)
                .setHeader(KafkaHeaders.TOPIC,topic)
                .build();
        log.info("Sending msg in {} topic:{}", topic,object.toString());
        kafkaTemplate.send(message);
    }
}
