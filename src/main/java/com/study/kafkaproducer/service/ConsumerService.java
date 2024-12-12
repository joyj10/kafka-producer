package com.study.kafkaproducer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

//    @KafkaListener(topics = "kafka-topic", groupId = "spring")
    public void consumer(String message) {
        System.out.println("Subscribed : " + message);
    }
}
