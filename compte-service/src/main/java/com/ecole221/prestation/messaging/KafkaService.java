package com.ecole221.prestation.messaging;


import com.ecole221.prestation.config.ConfigData;
import com.ecole221.prestation.config.service.MessageHelper;
import com.ecole221.prestation.kafka.avro.model.CustomerCreateRequestAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaService {

    private final MessageHelper<String, CustomerCreateRequestAvroModel> messageHelper;

    private final ConfigData configData;


    public KafkaService(MessageHelper<String, CustomerCreateRequestAvroModel> messageHelper, ConfigData configData) {
        this.messageHelper = messageHelper;
        this.configData = configData;
    }

    public void createCustumer(KafkaEvent<CustomerCreateRequestAvroModel> kafkaEvent){
        //create customer
        messageHelper.send(configData.getCustomerCreateTopicRequestName(), kafkaEvent.getEventId().toString(),
                kafkaEvent.getData());
    }

}
