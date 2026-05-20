package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private KafkaProducer producer;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }

    @PostMapping("/send-with-key")
    public ResponseEntity<String> sendMessageWithKey(@RequestBody Map<String, String> request) {
        String key = request.get("key");
        String message = request.get("message");
        producer.sendMessageWithKey(key, message);
        return ResponseEntity.ok("Message sent with key '" + key + "': " + message);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Kafka Demo App is running!");
    }
}
