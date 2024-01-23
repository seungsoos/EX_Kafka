package org.dummy.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.dummy.kafka.dto.KafkaSubRequestDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic-1", containerFactory = "containerListenerFactory", groupId = "test")
    private void testListener(@Payload KafkaSubRequestDto kafkaSubRequestDto, Acknowledgment ack, ConsumerRecordMetadata metadata) {
        log.info("> Kafka Consumer Read Start [KafkaSubRequestDto] : {}", kafkaSubRequestDto);
        ack.acknowledge();
        log.info("> Kafka Consumer Read End [KafkaSubRequestDto] : {}", kafkaSubRequestDto);
    }

}
