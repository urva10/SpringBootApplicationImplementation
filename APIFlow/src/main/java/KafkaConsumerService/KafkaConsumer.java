package KafkaConsumerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="maytopic",groupId="group_id")
    public void consume(String message) {
        System.out.print("consume message :" + message);
    }

}
