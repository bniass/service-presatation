package com.ecole221.prestation.mapper;


import com.ecole221.prestation.dto.CustomerCreateRequest;
import com.ecole221.prestation.dto.DepotCreateResponse;
import com.ecole221.prestation.kafka.avro.model.CustomerCreateRequestAvroModel;
import com.ecole221.prestation.model.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CompteServiceMapper {

    public CustomerCreateRequestAvroModel CustomerCreateRequestTocustomerCreateResponseAvroModel(CustomerCreateRequest customerCreateRequest){
        return CustomerCreateRequestAvroModel.newBuilder()
                .setNom(customerCreateRequest.getNom())
                .setPrenom(customerCreateRequest.getPrenom())
                .setDateNaissance(customerCreateRequest.getDateNaissance())
                .setTel(customerCreateRequest.getTel())
                .build();
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public DepotCreateResponse TransactionToDepotResponse(Transaction transaction){
        return DepotCreateResponse.builder()
                .date(transaction.getDate())
                .compteNo(transaction.getCompte().getNumeroCompte())
                .type(transaction.getType())
                .clientId(transaction.getCompte().getClientId())
                .montant(transaction.getMontant())
                .build();
    }


}
