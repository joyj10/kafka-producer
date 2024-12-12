package com.study.kafkaproducer.controller;

import com.study.kafkaproducer.service.ProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

//    @PostMapping("/message")
//    public void publishMessage(@RequestParam String message) {
//        producerService.pub(message);
//    }
}
