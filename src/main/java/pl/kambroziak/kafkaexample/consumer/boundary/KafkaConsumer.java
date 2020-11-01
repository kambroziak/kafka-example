package pl.kambroziak.kafkaexample.consumer.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "topic-1", groupId = "group-1")
    void consume(String message, @Header(KafkaHeaders.OFFSET) String offset) {
        logger.info("Consumerd message: " + message + " on offset: " + offset);
    }
}
