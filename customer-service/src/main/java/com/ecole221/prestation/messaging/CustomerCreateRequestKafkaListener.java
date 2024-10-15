package com.ecole221.prestation.messaging;

import com.ecole221.prestation.KafkaConsumer;
import com.ecole221.prestation.config.ConfigData;
import com.ecole221.prestation.config.service.MessageHelper;
import com.ecole221.prestation.kafka.avro.model.CustomerCreateRequestAvroModel;
import com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel;
import com.ecole221.prestation.kafka.avro.model.CustomerStatut;
import com.ecole221.prestation.mapper.CustomerMapper;
import com.ecole221.prestation.mapper.Mapper;
import com.ecole221.prestation.model.Customer;
import com.ecole221.prestation.service.ICustomer;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerCreateRequestKafkaListener implements KafkaConsumer<CustomerCreateRequestAvroModel> {
    private final Mapper mapper;
    private final ICustomer iCustomer;
    private final MessageHelper<String, CustomerCreateResponseAvroModel> messageHelper;
    private final ConfigData configData;
    private final CustomerMapper customerMapper;

    public CustomerCreateRequestKafkaListener(Mapper mapper, ICustomer iCustomer, MessageHelper<String, CustomerCreateResponseAvroModel> messageHelper, ConfigData configData, CustomerMapper customerMapper) {
        this.mapper = mapper;
        this.iCustomer = iCustomer;
        this.messageHelper = messageHelper;
        this.configData = configData;
        this.customerMapper = customerMapper;
    }


    @Override
    @KafkaListener(id = "${kafka-consumer-config.customer-group-id}", topics = "${topics.customer-create-topic-request-name}")
    public void receive(@Payload CustomerCreateRequestAvroModel message,
                        @Header(KafkaHeaders.RECEIVED_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                        @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("Data {}, key {}, partition {}, offset {}", message, key, partition, offset);
        createCustomer(message);
    }

    @Transactional
    private void createCustomer(CustomerCreateRequestAvroModel message) {
        Customer customer = iCustomer.findByTel(message.getTel());
        CustomerCreateResponseAvroModel customerCreateResponseAvroModel = new CustomerCreateResponseAvroModel();
        if(customer != null){
            customerCreateResponseAvroModel.setMessage("Customer avec tel : "+message.getTel()+" existe déjà!");
            customerCreateResponseAvroModel.setCustomerStatut(CustomerStatut.EXIST);
            customerCreateResponseAvroModel.setClientId(customer.getId()+"");
        }
        else{
            customer = customerMapper.customerCreateRequestAvromModelToCustomer(message);
            iCustomer.save(customer);
            customerCreateResponseAvroModel.setMessage("Customer créé avec l'id : "+customer.getId());
            customerCreateResponseAvroModel.setCustomerStatut(CustomerStatut.CREATED);
            customerCreateResponseAvroModel.setClientId(customer.getId()+"");
        }

        KafkaEvent<CustomerCreateResponseAvroModel> kafkaEvent = new KafkaEvent<>(customerCreateResponseAvroModel);

        messageHelper.send(configData.getCustomerCreateTopicResponseName(), kafkaEvent.getEventId().toString(), kafkaEvent.getData());
    }
}

