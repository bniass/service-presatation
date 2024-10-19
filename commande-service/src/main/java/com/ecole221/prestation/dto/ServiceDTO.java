package com.ecole221.prestation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDTO {
    private long id;
    private String libelle;
    private BigDecimal prix;
    private String description;
}
