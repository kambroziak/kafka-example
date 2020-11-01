package pl.kambroziak.kafkaexample.sender.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kambroziak.kafkaexample.sender.control.KafkaSender;

@RestController
public class NumberResource {

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("/start/{num}")
    public void start(@PathVariable("num") Integer num){
        kafkaSender.sendMessageWithCallback(num + "", "topic-1");
    }

}
