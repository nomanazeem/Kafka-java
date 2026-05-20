package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
        System.out.println("Kafka Demo Application Started!");
        System.out.println("Send messages via: POST http://localhost:8081/api/messages/send");
        System.out.println("View Kafka UI: http://localhost:8080");
    }
}