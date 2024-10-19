package com.ecole221.prestation.messaging;

import com.ecole221.prestation.KafkaConsumer;
import com.ecole221.prestation.kafka.avro.model.PaiementCreateResponseAvroModel;
import com.ecole221.prestation.model.Demande;
import com.ecole221.prestation.service.IDemande;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PaiementResponseKafkaListener implements KafkaConsumer<PaiementCreateResponseAvroModel> {
    private final IDemande iDemande;

    public PaiementResponseKafkaListener(IDemande iDemande) {
        this.iDemande = iDemande;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.paiement-group-id}", topics = "${topics.paiement-create-topic-response-name}")
    public void receive(@Payload PaiementCreateResponseAvroModel message,
                        @Header(KafkaHeaders.RECEIVED_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                        @Header(KafkaHeaders.OFFSET) Long offset) {
        // get and update commentaire and demande statut
        updateDamande(message);
    }

    @Transactional
    private void updateDamande(PaiementCreateResponseAvroModel paiementCreateResponseAvroModel) {
        Demande demande = iDemande.find(Long.parseLong(paiementCreateResponseAvroModel.getDemandeId()));
        demande.setStatut(paiementCreateResponseAvroModel.getPaiementStatut().name());
        demande.setCommentaire(paiementCreateResponseAvroModel.getMessage());
        iDemande.save(demande);
    }
}
