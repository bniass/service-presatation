package com.ecole221.prestation.controller;

import com.ecole221.prestation.dto.DemandeResponse;
import com.ecole221.prestation.dto.ServiceCreateRequest;
import com.ecole221.prestation.dto.ServiceDTO;
import com.ecole221.prestation.helper.ServiceHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

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

    @PostMapping
    public ServiceDTO save(@RequestBody ServiceCreateRequest serviceCreateRequest) {
        return serviceHelper.save(serviceCreateRequest);
    }

    @PutMapping
    public ServiceDTO update(@RequestBody ServiceDTO serviceDTO) {
        return serviceHelper.update(serviceDTO);
    }

    @GetMapping("/{id}")
    public ServiceDTO findService(@PathVariable long id){
        return serviceHelper.find(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        serviceHelper.remove(id);
        return ResponseEntity.ok("service supprimé !");
    }
}
