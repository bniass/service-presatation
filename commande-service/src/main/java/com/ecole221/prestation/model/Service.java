package com.ecole221.prestation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "serial")
    private long id;
    private String libelle;
    private BigDecimal prix;
    private String description;
    @OneToMany(mappedBy = "service")
    private List<Offre> offres;
}
