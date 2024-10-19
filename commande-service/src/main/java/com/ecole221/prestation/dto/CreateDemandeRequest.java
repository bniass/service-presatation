package com.ecole221.prestation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDemandeRequest {
    private LocalDate date;
    private String clientId;
    private List<OffreRequest> offresRequest;
    private BigDecimal prixTotal;
}
