package com.ecole221.prestation.messaging;

import com.ecole221.prestation.KafkaConsumer;
import com.ecole221.prestation.dto.CompteCreateRequest;
import com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel;
import com.ecole221.prestation.kafka.avro.model.CustomerStatut;
import com.ecole221.prestation.model.Compte;
import com.ecole221.prestation.model.Transaction;
import com.ecole221.prestation.service.CompteService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Component
public class CustomerKafkaListener implements KafkaConsumer<CustomerCreateResponseAvroModel> {

    private CompteCreateRequest compteCreateRequest;
    private final CompteService compteService;
    //private CustomerCreateResponseAvroModel customerCreateResponseAvroModel;


    public CustomerKafkaListener(CompteService compteService) {
        this.compteService = compteService;
    }

    public void initCompteCreateRequest(CompteCreateRequest compteCreateRequest){
        this.compteCreateRequest = compteCreateRequest;
    }


    /*
    public CustomerCreateResponseAvroModel getStatut(){
        return customerCreateResponseAvroModel;
    }
    */
    @Override
    @KafkaListener(id = "${kafka-consumer-config.customer-group-id}", topics = "${topics.customer-create-topic-response-name}")
    public void receive(@Payload CustomerCreateResponseAvroModel message,
                        @Header(KafkaHeaders.RECEIVED_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                        @Header(KafkaHeaders.OFFSET) Long offset) {
        getData(message);
    }

    @Transactional
    public void getData(CustomerCreateResponseAvroModel customerCreateResponseAvroModel){
        if(customerCreateResponseAvroModel.getCustomerStatut().equals(CustomerStatut.CREATED)){
            // créate compte
            Compte compte = new Compte();
            compte.setClientId(Long.parseLong(customerCreateResponseAvroModel.getClientId()));
            compte.setNumeroCompte("C-"+String.format("%08d", Integer.parseInt(customerCreateResponseAvroModel.getClientId())));
            compte.setSolde(compteCreateRequest.getMontant());
            Transaction transaction = new Transaction();
            transaction.setCompte(compte);
            transaction.setDate(LocalDate.now());
            transaction.setType("DEPOT");
            transaction.setMontant(compteCreateRequest.getMontant());
            transaction.setDemandeId(0);
            compte.setTransactions(List.of(transaction));
            compteService.save(compte);
        }
    }
}
