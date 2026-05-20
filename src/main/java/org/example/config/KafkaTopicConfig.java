package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder.name("demo-topic")
                .partitions(3)  // 3 partitions for parallel processing
                .replicas(1)    // 1 replica (since we have 1 broker)
                .build();
    }
}
