package block15kafka.block15kafka.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    private static final String TOPIC = "my-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        if (kafkaTemplate != null) {
            kafkaTemplate.send(TOPIC, message);
        } else {
            // Log o manejo de error si kafkaTemplate es nulo
            System.out.println("kafkaTemplate is null");
        }
    }
}
