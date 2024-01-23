package org.dummy.kafka.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dummy.kafka.dto.KafkaPubRequestDto;
import org.dummy.kafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/kafka")
@Slf4j
@RequiredArgsConstructor
public class KafkaPubController {

    private final KafkaProducer kafkaProducer;
    private final AtomicLong messageId = new AtomicLong(0);

    @PostMapping("/pub")
    void pubMessage(@RequestBody KafkaPubRequestDto kafkaPubRequestDto){
        LocalDateTime now = LocalDateTime.now();
        log.info("> Kafka Message Pub [time] :{}", now);
        kafkaPubRequestDto.setMessageId(messageId.getAndIncrement());
        kafkaProducer.send(kafkaPubRequestDto);
    }


}
