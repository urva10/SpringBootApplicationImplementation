package KafkaController;

import KafkaProducerService.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;


    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return "message send to kafka" +message;
    }
}
