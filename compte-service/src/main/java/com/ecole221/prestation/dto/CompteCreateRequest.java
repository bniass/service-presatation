package com.ecole221.prestation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompteCreateRequest {
    private CustomerCreateRequest customerCreateRequest;
    @NotNull(message = "montant obligatoire !")
    private BigDecimal montant;
}
