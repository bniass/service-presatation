package com.ecole221.prestation.mapper;

import com.ecole221.prestation.dto.*;
import com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel;
import com.ecole221.prestation.kafka.avro.model.PaiementStatut;
import com.ecole221.prestation.model.Demande;
import com.ecole221.prestation.model.Offre;
import com.ecole221.prestation.model.Service;
import com.ecole221.prestation.service.IService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CommandeMapper {
    private final IService iService;

    public CommandeMapper(IService iService) {
        this.iService = iService;
    }

    public CreateDemandeResponse demandeEntityToCreateDemandeResponse(Demande demande){
        return CreateDemandeResponse.builder()
                .offresResponse(demande.getOffres().stream().map(
                        this::offreEntityToOffreResponse
                ).toList())
                .date(demande.getDate())
                .trackingId(demande.getTrackingId())
                .id(demande.getId())
                .build();
    }

    public Demande createDemandeRequestToDemandeEntity(CreateDemandeRequest createDemandeRequest){
        return Demande.builder()
                .date(createDemandeRequest.getDate())
                .clientId(Long.parseLong(createDemandeRequest.getClientId()))
                .commentaire("")
                .trackingId(UUID.randomUUID().toString())
                .statut(PaiementStatut.EN_ATTENTE.name())
                .offres(createDemandeRequest.getOffresRequest().stream()
                        .map(this::offreRequestToOffreEntity).toList())
                .build();
    }

    public Offre offreRequestToOffreEntity(OffreRequest offreRequest){
        return Offre.builder()
                .dateDebut(LocalDate.parse(offreRequest.getDateDebut(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .dateFin(LocalDate.parse(offreRequest.getDateFin(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .descriptif(offreRequest.getDescriptif())
                .service(iService.find(offreRequest.getServiceId()))
                .build();
    }

    public OffreResponse offreEntityToOffreResponse(Offre offre){
        return OffreResponse.builder()
                .serviceDTO(serviceEntityToServiceDTO(offre.getService()))
                .dateFin(offre.getDateFin().toString())
                .dateDebut(offre.getDateDebut().toString())
                .descriptif(offre.getDescriptif())
                .build();
    }

    public ServiceDTO serviceEntityToServiceDTO(Service service){
        return ServiceDTO.builder()
                .id(service.getId())
                .prix(service.getPrix())
                .description(service.getDescription())
                .libelle(service.getLibelle())
                .build();
    }

    public Service serviceDTOToServiceEntity(ServiceDTO serviceDTO){
        return Service.builder()
                .id(serviceDTO.getId())
                .prix(serviceDTO.getPrix())
                .description(serviceDTO.getDescription())
                .libelle(serviceDTO.getLibelle())
                .build();
    }

    public Service ServiceCreateRequestToServiceEntity(ServiceCreateRequest serviceCreateRequest){
        return Service.builder()
                .prix(serviceCreateRequest.getPrix())
                .description(serviceCreateRequest.getDescription())
                .libelle(serviceCreateRequest.getLibelle())
                .build();
    }

    public PaiementCreateRequestAvroModel createDemandeRequestToPaiementCreateRequestAvroModel(CreateDemandeRequest createDemandeRequest){
        return PaiementCreateRequestAvroModel.newBuilder()
                .setClientId(createDemandeRequest.getClientId())
                .setMontant(createDemandeRequest.getPrixTotal())
                .setDemandeId("")
                .setMessage("INIT")
                .setPaiementStatut(PaiementStatut.EN_ATTENTE)
                .build();
    }

    public DemandeResponse demandeEntityToDemandeResponse(Demande demande) {
        return DemandeResponse.builder()
                .createDemandeResponse(demandeEntityToCreateDemandeResponse(demande))
                .commentaire(demande.getCommentaire())
                .statut(demande.getStatut())
                .build();
    }
}
