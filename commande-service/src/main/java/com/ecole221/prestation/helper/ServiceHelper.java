package com.ecole221.prestation.helper;

import com.ecole221.prestation.dto.ServiceCreateRequest;
import com.ecole221.prestation.dto.ServiceDTO;
import com.ecole221.prestation.exception.CommandeServiceNotFoundException;
import com.ecole221.prestation.mapper.CommandeMapper;
import com.ecole221.prestation.model.Service;
import com.ecole221.prestation.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceHelper {
    private final CommandeMapper mapper;
    private final IService iService;


    public ServiceHelper(CommandeMapper mapper, IService iService) {
        this.mapper = mapper;
        this.iService = iService;
    }

    public List<ServiceDTO> findAll(){
        return iService.findAll().stream().map(mapper::serviceEntityToServiceDTO)
                .toList();
    }

    public ServiceDTO find(long id){
        Service service = iService.find(id);
        if(service == null){
            throw new CommandeServiceNotFoundException("Service avec id : "+id+" introuvable");
        }
        return mapper.serviceEntityToServiceDTO(service);
    }

    public ServiceDTO save(ServiceCreateRequest serviceCreateRequest) {
        return mapper.serviceEntityToServiceDTO(iService
                .save(mapper.ServiceCreateRequestToServiceEntity(serviceCreateRequest)));
    }

    public ServiceDTO update(ServiceDTO serviceDTO) {
        Service service = iService.find(serviceDTO.getId());
        if(service == null){
            throw new CommandeServiceNotFoundException("Service avec id : "+serviceDTO.getId()+" introuvable");
        }
        return mapper.serviceEntityToServiceDTO(iService
                .save(mapper.serviceDTOToServiceEntity(serviceDTO)));
    }

    public void remove(long id) {
        Service service = iService.find(id);
        if(service == null){
            throw new CommandeServiceNotFoundException("Service avec id : "+id+" introuvable");
        }
        iService.remove(id);
    }
}
