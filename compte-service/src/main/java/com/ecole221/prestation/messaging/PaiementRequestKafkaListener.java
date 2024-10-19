package com.ecole221.prestation.messaging;

import com.ecole221.prestation.KafkaConsumer;
import com.ecole221.prestation.config.ConfigData;
import com.ecole221.prestation.config.service.MessageHelper;
import com.ecole221.prestation.exception.CompteServiceException;
import com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel;
import com.ecole221.prestation.kafka.avro.model.PaiementCreateResponseAvroModel;
import com.ecole221.prestation.kafka.avro.model.PaiementStatut;
import com.ecole221.prestation.mapper.CompteServiceMapper;
import com.ecole221.prestation.model.Compte;
import com.ecole221.prestation.model.Transaction;
import com.ecole221.prestation.service.ICompte;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PaiementRequestKafkaListener implements KafkaConsumer<PaiementCreateRequestAvroModel> {
    private final CompteServiceMapper mapper;
    private final ICompte iCompte;
    private final MessageHelper<String, PaiementCreateResponseAvroModel> messageHelper;
    private final ConfigData configData;

    public PaiementRequestKafkaListener(CompteServiceMapper mapper, ICompte iCompte, MessageHelper<String, PaiementCreateResponseAvroModel> messageHelper, ConfigData configData) {
        this.mapper = mapper;
        this.iCompte = iCompte;
        this.messageHelper = messageHelper;
        this.configData = configData;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.paiement-group-id}", topics = "${topics.paiement-create-topic-request-name}")
    public void receive(@Payload PaiementCreateRequestAvroModel message,
                        @Header(KafkaHeaders.RECEIVED_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                        @Header(KafkaHeaders.OFFSET) Long offset) {
        handlePaiement(message);
    }

    @Transactional
    private void handlePaiement(PaiementCreateRequestAvroModel paiementCreateRequestAvroModel) {
        Compte compte = iCompte.findByClientId(Long.parseLong(paiementCreateRequestAvroModel.getClientId()));
        //BigDecimal donne les add subtarcr mutiply comprareTo,  (comparTo return 0 (si les deux
        // ont la même valeur, 1 si le premier est plus grant -1 si le deuxieme est plus grand)
        if(compte.getSolde().compareTo(paiementCreateRequestAvroModel.getMontant()) < 1){
            // send to kafka with statut echec
            PaiementCreateResponseAvroModel paiementCreateResponseAvroModel =
                    createResponseAvroModel("Solde insuffisant, du : "+paiementCreateRequestAvroModel.getMontant()+", dispo: "+ compte.getSolde(),
                    PaiementStatut.ECHEC, paiementCreateRequestAvroModel.getClientId(), paiementCreateRequestAvroModel.getDemandeId());
            KafkaEvent<PaiementCreateResponseAvroModel> kafkaEvent = new KafkaEvent<>(paiementCreateResponseAvroModel);
            messageHelper.send(configData.getPaiementCreateTopicResponseName(), kafkaEvent.getEventId().toString(), kafkaEvent.getData());
            return;
        }
        try {
            Transaction transaction = mapper.
                    PaiementCreateRequestAvroModelToTransaction(paiementCreateRequestAvroModel);
            transaction.setCompte(compte);
            compte.setSolde(compte.getSolde().subtract(paiementCreateRequestAvroModel.getMontant()));
            compte.getTransactions().add(transaction);
            iCompte.save(compte);
            PaiementCreateResponseAvroModel paiementCreateResponseAvroModel = createResponseAvroModel("Paiement efféctué avec succès",
                    PaiementStatut.TERMINE, paiementCreateRequestAvroModel.getClientId(), paiementCreateRequestAvroModel.getDemandeId());
            KafkaEvent<PaiementCreateResponseAvroModel> kafkaEvent = new KafkaEvent<>(paiementCreateResponseAvroModel);
            messageHelper.send(configData.getPaiementCreateTopicResponseName(), kafkaEvent.getEventId().toString(), kafkaEvent.getData());
        } catch (CompteServiceException e) {
            PaiementCreateResponseAvroModel paiementCreateResponseAvroModel = createResponseAvroModel(e.getMessage(),
                    PaiementStatut.ECHEC, paiementCreateRequestAvroModel.getClientId(), paiementCreateRequestAvroModel.getDemandeId());
            KafkaEvent<PaiementCreateResponseAvroModel> kafkaEvent = new KafkaEvent<>(paiementCreateResponseAvroModel);
            messageHelper.send(configData.getPaiementCreateTopicResponseName(), kafkaEvent.getEventId().toString(), kafkaEvent.getData());
            throw new CompteServiceException(e.getMessage());
        }

    }

    private PaiementCreateResponseAvroModel createResponseAvroModel(String message, PaiementStatut paiementStatut, String clientId, String demandeId){
        return PaiementCreateResponseAvroModel.newBuilder()
                .setPaiementStatut(paiementStatut)
                .setClientId(clientId)
                .setDemandeId(demandeId)
                .setMessage(message)
                .build();
    }
}
