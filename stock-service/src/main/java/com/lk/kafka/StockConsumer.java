package com.lk.kafka;

import com.example.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {

    private static final Logger logger = LoggerFactory.getLogger(StockConsumer.class);

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public StockConsumer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.name}")
    public void consumeMessage(OrderEvent orderEvent){
        logger.info(String.format("Event Received -> %s ",orderEvent.toString()));
    }
}
