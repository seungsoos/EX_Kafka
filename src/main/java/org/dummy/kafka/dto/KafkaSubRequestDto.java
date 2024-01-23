package org.dummy.library.kafka.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class KafkaSubRequestDto {
    private Long messageId;

    private String message;

    private LocalDateTime sendDt;

    public KafkaSubRequestDto() {
    }

}
