package block15kafka.block15kafka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "producer_topic";

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Sent message: " + message;
    }
}