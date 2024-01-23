package org.dummy.library.kafka.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class KafkaPubRequestDto {

    private Long messageId;

    private String message;

    private LocalDateTime sendDt;

    public KafkaPubRequestDto() {
    }

    public KafkaPubRequestDto(Long messageId, String message) {
        this.messageId = messageId;
        this.message = message;
        this.sendDt = LocalDateTime.now();
    }
}
