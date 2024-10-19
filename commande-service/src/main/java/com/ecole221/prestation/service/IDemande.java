package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Demande;

import java.util.List;

public interface IDemande {
    Demande save(Demande demande);
    Demande find(long id);
    List<Demande> findAll();
    Demande findByTrackingId(String trackingId);
    void removedemandeWhitnStatut(String statut);
}

