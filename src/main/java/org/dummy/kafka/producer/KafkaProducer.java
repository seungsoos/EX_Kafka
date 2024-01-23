package org.dummy.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dummy.kafka.dto.KafkaPubRequestDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, KafkaPubRequestDto> kafkaTemplate;

    public void send(KafkaPubRequestDto kafkaPubRequestDto){
        log.info("> Kafka Producer Send Start [message] : {}", kafkaPubRequestDto);
        kafkaTemplate.send("test-topic-1", kafkaPubRequestDto);
        log.info("> Kafka Producer Send End [message] : {}", kafkaPubRequestDto);
    }

}
