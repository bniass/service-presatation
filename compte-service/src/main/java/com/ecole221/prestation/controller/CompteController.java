package com.ecole221.prestation.controller;


import com.ecole221.prestation.dto.CompteCreateRequest;
import com.ecole221.prestation.dto.CompteCreateResponse;
import com.ecole221.prestation.dto.DepotCreateRequest;
import com.ecole221.prestation.dto.DepotCreateResponse;
import com.ecole221.prestation.helper.CompteHelper;
import com.ecole221.prestation.messaging.CustomerKafkaListener;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compte")
public class CompteController {

    private final CompteHelper compteHelper;

    private final CustomerKafkaListener customerResponseKafkaListener;
    private final ModelMapper modelMapper;

    public CompteController(CompteHelper compteHelper, CustomerKafkaListener customerResponseKafkaListener, ModelMapper modelMapper) {
        this.compteHelper = compteHelper;
        this.customerResponseKafkaListener = customerResponseKafkaListener;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public void createCompte(@RequestBody CompteCreateRequest compteCreateRequest) throws InterruptedException {
        customerResponseKafkaListener.initCompteCreateRequest(compteCreateRequest);
        compteHelper.createCompte(compteCreateRequest);
    }

    @PostMapping("/depot")
    public DepotCreateResponse createDepot(@RequestBody DepotCreateRequest depotCreateRequest) throws InterruptedException {
        return compteHelper.depot(depotCreateRequest);
    }

    @GetMapping("/{clientId}")
    public CompteCreateResponse getCompte(@PathVariable long clientId){
        return compteHelper.getCompteByClientId(clientId);
    }
}
