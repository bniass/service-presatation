package com.ecole221.prestation.helper;

import com.ecole221.prestation.dto.ServiceDTO;
import com.ecole221.prestation.mapper.CommandeMapper;
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
}
