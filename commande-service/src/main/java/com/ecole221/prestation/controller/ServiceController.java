package com.ecole221.prestation.controller;

import com.ecole221.prestation.dto.ServiceDTO;
import com.ecole221.prestation.helper.ServiceHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/demandes/services")
public class ServiceController {

    private final ServiceHelper serviceHelper;

    public ServiceController(ServiceHelper serviceHelper) {
        this.serviceHelper = serviceHelper;
    }

    @GetMapping("/list")
    public List<ServiceDTO> findAll(){
        return serviceHelper.findAll();
    }
}
