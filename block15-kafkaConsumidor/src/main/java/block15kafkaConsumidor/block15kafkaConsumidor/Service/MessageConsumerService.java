package block15kafkaConsumidor.block15kafkaConsumidor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class MessageConsumerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "my-topic";


    @KafkaListener(topics = "producer_topic", groupId = "my-group")
    public void listen(String message) {
        // Procesa el mensaje recibido
        System.out.println("Received Message: " + message);

        // Enviar la respuesta a un topic diferente
        kafkaTemplate.send("response-topic", "Respuesta para el mensaje: " + message);
    }
}
