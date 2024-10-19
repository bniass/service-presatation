package com.ecole221.prestation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffreResponse {
    private ServiceDTO serviceDTO;
    private String dateDebut;
    private String dateFin;
    private String descriptif;
}
