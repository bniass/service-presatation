package com.ecole221.prestation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffreRequest {
    @NotNull
    private long serviceId;
    @NotNull
    private String dateDebut;
    @NotNull
    private String dateFin;
    @NotNull
    private String descriptif;
}
