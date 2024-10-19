package com.ecole221.prestation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "serial")
    private long id;
    private LocalDate date;
    private String trackingId;
    private long clientId;
    @OneToMany(mappedBy = "demande", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Offre> offres;
    @Column(length = 15)
    private String statut;
    private String commentaire;
}
