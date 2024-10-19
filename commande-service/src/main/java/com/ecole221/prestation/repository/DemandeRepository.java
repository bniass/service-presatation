package com.ecole221.prestation.repository;

import com.ecole221.prestation.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    Demande findByTrackingId(String trackingId);
    void deleteByStatut(String statut);
}
