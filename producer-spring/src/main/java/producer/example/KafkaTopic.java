package producer.example;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaTopic {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public void send(String message){

        kafkaTemplate.send("topico", message);
        log.info("Payload: {}",  message);

    }
}
