package com.apache.kafka.sample.controller;

import com.apache.kafka.sample.service.ConsumerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Value("${kafka.topic.name}")
    private String topicName;
    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }
}
