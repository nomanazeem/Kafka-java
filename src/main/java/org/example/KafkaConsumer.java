package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consume(String message) {
        logger.info("Received message: {}", message);
        processMessage(message);
    }

    private void processMessage(String message) {
        // Simulate processing
        logger.info("Processing message: {}", message.toUpperCase());
    }
}
