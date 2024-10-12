package com.ecole221.prestation;

import org.apache.avro.specific.SpecificRecordBase;

public interface KafkaConsumer<T extends SpecificRecordBase> {
    void receive(T message, String key, Integer partition, Long offset);
}