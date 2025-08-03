package com.mayank.kafkaFirst.controllers;


import com.mayank.kafkaFirst.payloads.Student;
import com.mayank.kafkaFirst.services.producers.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage("Test",message);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
        kafkaProducer.sendJsonMessage("TestJson",student);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
