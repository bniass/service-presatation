package com.ecole221.prestation.controller;

import com.ecole221.prestation.dto.CreateDemandeRequest;
import com.ecole221.prestation.dto.CreateDemandeResponse;
import com.ecole221.prestation.dto.DemandeResponse;
import com.ecole221.prestation.helper.DemandeHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//@CrossOrigin
@RestController
@RequestMapping("/api/demandes")
public class DemandeComtroller {
    private final DemandeHelper demandeHelper;

    public DemandeComtroller(DemandeHelper demandeHelper) {
        this.demandeHelper = demandeHelper;
    }

    @PostMapping
    public ResponseEntity<CreateDemandeResponse> saveDemande(@RequestBody CreateDemandeRequest createDemandeRequest){
        CreateDemandeResponse createDemandeResponse = demandeHelper.createDemande(createDemandeRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{trackingId}")
                .buildAndExpand(createDemandeResponse.getTrackingId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{trackingId}")
    public DemandeResponse findDemande(@PathVariable String trackingId){
        return demandeHelper.getDemande(trackingId);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeDemandeEchec(){
        if(demandeHelper.removeDemandeWithStatutEchec()){
            return ResponseEntity.ok("Removed!");
        }
        return ResponseEntity.ok("Not removed!");
    }

}
