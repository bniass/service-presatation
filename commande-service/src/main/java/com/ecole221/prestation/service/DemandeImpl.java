package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Demande;
import com.ecole221.prestation.repository.DemandeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeImpl implements IDemande{
    private final DemandeRepository demandeRepository;

    public DemandeImpl(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    @Override
    public Demande save(Demande demande) {
        return demandeRepository.save(demande);
    }

    @Override
    public Demande find(long id) {
        return demandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    @Override
    public Demande findByTrackingId(String trackingId) {
        return demandeRepository.findByTrackingId(trackingId);
    }

    @Transactional
    @Override
    public void removedemandeWhitnStatut(String statut) {
        demandeRepository.deleteByStatut(statut);
    }
}
