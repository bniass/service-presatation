package com.ecole221.prestation.service;


import com.ecole221.prestation.model.Compte;
import com.ecole221.prestation.repository.CompteRepository;
import org.springframework.stereotype.Service;

@Service
public class CompteService implements ICompte{
    private final CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Compte findByClientId(long clientId) {
        return compteRepository.findByClientId(clientId);
    }
}
