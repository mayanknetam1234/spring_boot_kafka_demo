package com.mayank.kafkaFirst.services.producers;

public interface KafkaProducer {

    void sendMessage(String topic,String msg);
    <T> void sendJsonMessage(String topic, T object);
}
