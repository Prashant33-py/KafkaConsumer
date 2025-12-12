package com.apache.kafka.sample.service;

import com.apache.kafka.sample.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
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

    @KafkaListener(topics = "${kafka.another.topic.name}", groupId = "${kafka.another.consumer.group.id}", topicPartitions = {
            @TopicPartition(
                    topic = "${kafka.another.topic.name}",
                    partitions = {"2"}
            )
    })
    public void consumeMessageFromAnotherTopic(String message) {
        logger.info("Consumer consumed the message from another topic: {}",message);
    }

}
