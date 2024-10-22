package com.ecole221.prestation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemandeResponse {
    private CreateDemandeResponse createDemandeResponse;
    private String statut;
    private String commentaire;

}
