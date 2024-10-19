package com.ecole221.prestation.controller;

import com.ecole221.prestation.dto.CreateDemandeRequest;
import com.ecole221.prestation.dto.CreateDemandeResponse;
import com.ecole221.prestation.helper.DemandeHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demandes")
public class DemandeComtroller {
    private final DemandeHelper demandeHelper;

    public DemandeComtroller(DemandeHelper demandeHelper) {
        this.demandeHelper = demandeHelper;
    }

    @PostMapping
    public CreateDemandeResponse saveDemande(@RequestBody CreateDemandeRequest createDemandeRequest){
        return demandeHelper.createDemande(createDemandeRequest);
    }

    @GetMapping("/{trackingId}")
    public CreateDemandeResponse findDemande(@PathVariable String trackingId){
        return demandeHelper.getDemande(trackingId);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeDemandeEchec(){
        demandeHelper.removeDemandeWithStatutEchec();
        return ResponseEntity.ok("Removed!");
    }

}
