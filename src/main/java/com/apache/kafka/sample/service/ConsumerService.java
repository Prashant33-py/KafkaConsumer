package com.apache.kafka.sample.service;

import com.apache.kafka.sample.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    Logger logger = LoggerFactory.getLogger(ConsumerService.class);

//    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void consumeMessageFromTopic(String message) {
        logger.info("Consumer consumed the message: {}",message);
    }

//    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void consumeMessageFromTopicDuplicate(String message) {
        logger.info("Consumer duplicate consumed the message: {}",message);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void consumeCustomerFromTopic(Customer customer) {
        logger.info("Consumer consumed the customer object: {}",customer);
    }

}
