package com.ecole221.prestation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "serial")
    private long id;

    @ManyToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String descriptif;
}
