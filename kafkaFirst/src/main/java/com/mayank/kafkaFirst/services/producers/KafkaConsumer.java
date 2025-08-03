package com.mayank.kafkaFirst.services.producers;

import com.mayank.kafkaFirst.payloads.Student;

public interface KafkaConsumer {
    void TestTopicConsumer(String msg);
    void TestJsonTopicConsumer(Student student);
}
