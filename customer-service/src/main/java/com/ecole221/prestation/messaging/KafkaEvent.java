package com.ecole221.prestation.messaging;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class KafkaEvent<T> {
    private T data;
    private UUID eventId;

    public KafkaEvent(T data) {
        this.data = data;
        eventId = UUID.randomUUID();
    }
}
