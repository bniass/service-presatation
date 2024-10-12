package com.ecole221.prestation.helper;


import com.ecole221.prestation.dto.CompteCreateRequest;
import com.ecole221.prestation.dto.CompteCreateResponse;
import com.ecole221.prestation.dto.DepotCreateRequest;
import com.ecole221.prestation.dto.DepotCreateResponse;
import com.ecole221.prestation.exception.CompteServiceException;
import com.ecole221.prestation.kafka.avro.model.CustomerCreateRequestAvroModel;
import com.ecole221.prestation.mapper.CompteServiceMapper;
import com.ecole221.prestation.messaging.KafkaEvent;
import com.ecole221.prestation.messaging.KafkaService;
import com.ecole221.prestation.model.Compte;
import com.ecole221.prestation.model.Transaction;
import com.ecole221.prestation.service.ICompte;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CompteHelper {
    private final KafkaService kafkaService;
    private final ICompte iCompte;
    private final ModelMapper modelMapper;
    private final CompteServiceMapper compteServiceMapper;

    public CompteHelper(KafkaService kafkaService, ICompte iCompte, ModelMapper modelMapper, CompteServiceMapper compteServiceMapper) {
        this.kafkaService = kafkaService;
        this.iCompte = iCompte;
        this.modelMapper = modelMapper;
        this.compteServiceMapper = compteServiceMapper;
    }

    public CompteCreateResponse createCompte(CompteCreateRequest compteCreateRequest){
        if(compteCreateRequest.getMontant().compareTo(BigDecimal.valueOf(10000)) < 0){
            throw new CompteServiceException("montant initial ["+compteCreateRequest.getMontant()+"] doit être >= 10000");
        }
        CustomerCreateRequestAvroModel customerCreateRequestAvroModel =
                compteServiceMapper.CustomerCreateRequestTocustomerCreateResponseAvroModel(compteCreateRequest
                        .getCustomerCreateRequest());
        KafkaEvent<CustomerCreateRequestAvroModel> createCustumerEvent = new KafkaEvent<>(customerCreateRequestAvroModel);
        kafkaService.createCustumer(createCustumerEvent);
        return null;
    }

    public CompteCreateResponse getCompteByClientId(long clientId){
        Compte compte = iCompte.findByClientId(clientId);
        if(compte == null){
            throw new CompteServiceException("Compte avec le numéro client "+clientId+" introuvable !");
        }
        return modelMapper.map(compte, CompteCreateResponse.class);
    }

    public DepotCreateResponse depot(DepotCreateRequest depotCreateRequest){
        BigDecimal montant = BigDecimal.ONE;
        try {
            montant = BigDecimal.valueOf(Long.parseLong(depotCreateRequest.getMontant()));
        } catch (NumberFormatException e) {
            throw new CompteServiceException("Montant dépot invalide !");
        }
        if(montant.compareTo(BigDecimal.valueOf(5000)) < 0){
            throw new CompteServiceException("montant dépot ["+montant+"] doit être >= 5000");
        }
        Compte compte = iCompte.findByClientId(Long.parseLong(depotCreateRequest.getClientId()));
        if(compte == null){
            throw new CompteServiceException("Compte client ["+depotCreateRequest.getClientId()+"] introuvable!");
        }
        Transaction transaction = new Transaction();
        transaction.setCompte(compte);
        transaction.setDate(LocalDate.now());
        transaction.setType("DEPOT");
        transaction.setMontant(montant);
        transaction.setDemandeId(0);
        compte.getTransactions().add(transaction);
        compte.setSolde(compte.getSolde().add(montant));
        transaction.setCompte(compte);
        iCompte.save(compte);
        return compteServiceMapper.TransactionToDepotResponse(transaction);
    }


}
