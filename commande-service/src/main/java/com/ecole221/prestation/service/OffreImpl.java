package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Offre;
import com.ecole221.prestation.repository.OffreReposirtory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreImpl implements IOffre{
    private final OffreReposirtory offreRepository;

    public OffreImpl(OffreReposirtory offreRepository) {
        this.offreRepository = offreRepository;
    }

    @Override
    public Offre save(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public Offre find(long id) {
        return offreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Offre> findAll() {
        return offreRepository.findAll();
    }
}
