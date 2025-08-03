package com.mayank.kafkaFirst.services.producers.imp;

import com.mayank.kafkaFirst.services.producers.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
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
}
