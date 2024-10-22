package com.ecole221.prestation.helper;

import com.ecole221.prestation.config.ConfigData;
import com.ecole221.prestation.config.service.MessageHelper;
import com.ecole221.prestation.dto.CreateDemandeRequest;
import com.ecole221.prestation.dto.CreateDemandeResponse;
import com.ecole221.prestation.dto.DemandeResponse;
import com.ecole221.prestation.dto.OffreRequest;
import com.ecole221.prestation.exception.CommandeServiceException;
import com.ecole221.prestation.exception.CommandeServiceNotFoundException;
import com.ecole221.prestation.exception.CustomException;
import com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel;
import com.ecole221.prestation.kafka.avro.model.PaiementStatut;
import com.ecole221.prestation.mapper.CommandeMapper;
import com.ecole221.prestation.messaging.KafkaEvent;
import com.ecole221.prestation.model.Demande;
import com.ecole221.prestation.model.Service;
import com.ecole221.prestation.proxy.CustomerProxy;
import com.ecole221.prestation.service.IDemande;
import com.ecole221.prestation.service.IService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DemandeHelper {
    private final IDemande iDemande;
    private final CommandeMapper mapper;
    private final IService iService;
    private final MessageHelper<String, PaiementCreateRequestAvroModel> messageHelper;
    private final ConfigData configData;
    private final CustomerProxy customerProxy;

    public DemandeHelper(IDemande iDemande, CommandeMapper mapper, IService iService, MessageHelper<String, PaiementCreateRequestAvroModel> messageHelper, ConfigData configData, CustomerProxy customerProxy) {
        this.iDemande = iDemande;
        this.mapper = mapper;
        this.iService = iService;
        this.messageHelper = messageHelper;
        this.configData = configData;
        this.customerProxy = customerProxy;
    }

    public CreateDemandeResponse createDemande(CreateDemandeRequest createDemandeRequest){
        //check client
        if(customerProxy.findCustomer(createDemandeRequest.getClientId()) == null){
            throw new CommandeServiceNotFoundException("Customer avec id "+createDemandeRequest.getClientId()+" introuvable!");
        }
        List<Service> services = iService.findAll();
        List<Long> serviceIds = createDemandeRequest.getOffresRequest().stream()
                .map(OffreRequest::getServiceId).toList();
        // check services if exist
        List<String> errors = checkServiceIfExist(services, serviceIds);
        if(!errors.isEmpty()){
            throw new CustomException(errors);
        }

        // check total price if equals as sum prices of services
        BigDecimal total = services.stream().filter(service -> serviceIds.contains(service.getId()))
                .map(Service::getPrix)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if(total.compareTo(createDemandeRequest.getPrixTotal()) != 0){
            throw new CommandeServiceException("Total invalide, doit être egal à "+total);
        }
        //check if datefin come after datedebut for any offre
        createDemandeRequest.getOffresRequest().forEach(offreRequest -> {
            Optional<LocalDate> dateDebut = toLocalDate(offreRequest.getDateDebut());
            if(dateDebut.isEmpty()){
                errors.add("date debut ["+ offreRequest.getDateDebut()+"] invalide pour service id: "+offreRequest.getServiceId());
            }
            Optional<LocalDate> dateFin = toLocalDate(offreRequest.getDateFin());
            if(toLocalDate(offreRequest.getDateFin()).isEmpty()){
                errors.add("date fin ["+ offreRequest.getDateFin()+"] invalide pour service id: "+offreRequest.getServiceId());
            }
            if (dateDebut.isPresent() && dateFin.isPresent()) {
                if(dateFin.get().isBefore(dateDebut.get())){
                    errors.add("Service id : "+offreRequest.getServiceId()+", date fin ["+ offreRequest.getDateFin()+"] < ["+offreRequest.getDateDebut()+"]");
                }
            }
        });

        if(!errors.isEmpty()){
            throw new CustomException(errors);
        }

        Demande demande = mapper.createDemandeRequestToDemandeEntity(createDemandeRequest);
        demande.getOffres().stream().forEach(d->{
            d.setDemande(demande);
        });
        //sauvegarder la demande
        iDemande.save(demande);

        //mapper demande vers PaiementCreateRequestAvroModel
        PaiementCreateRequestAvroModel paiementCreateRequestAvroModel = mapper
                .createDemandeRequestToPaiementCreateRequestAvroModel(createDemandeRequest);
        paiementCreateRequestAvroModel.setDemandeId(demande.getId()+"");
        paiementCreateRequestAvroModel.setMessage("");

        KafkaEvent<PaiementCreateRequestAvroModel> paiementCreateRequestAvroModelKafkaEvent = new KafkaEvent<>(paiementCreateRequestAvroModel);
        messageHelper.send(configData.getPaiementCreateTopicRequestName(), paiementCreateRequestAvroModelKafkaEvent.getEventId().toString(),
                paiementCreateRequestAvroModelKafkaEvent.getData());
        return mapper.demandeEntityToCreateDemandeResponse(demande);
    }
    public Optional<LocalDate> toLocalDate(String dateString) {
        try {
            return Optional.of(LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }

    private List<String> checkServiceIfExist(List<Service> services, List<Long> serviceIds){
        List<String> erros = new ArrayList<>();
        List<Long> allServiceIds = services.stream().map(Service::getId).toList();
        serviceIds.stream().filter(ss->!allServiceIds.contains(ss)).forEach(sss->erros.add("service avec id : "+sss+" n'existe pas"));
        return erros;
    }

    public DemandeResponse getDemande(String trackingId){
        Demande demande = iDemande.findByTrackingId(trackingId);
        if(demande == null){
            throw new CommandeServiceNotFoundException(("Demande avec tracking ID :"+trackingId+" introuvable !"));
        }
        return mapper.demandeEntityToDemandeResponse(demande);
    }
    public boolean removeDemandeWithStatutEchec(){
        try {
            iDemande.removedemandeWhitnStatut(PaiementStatut.ECHEC.name());
            return true;
        } catch (Exception e) {
            throw new CommandeServiceException("Error: "+e.getMessage());
        }
    }
}
