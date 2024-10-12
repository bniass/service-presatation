package com.ecole221.prestation.repository;

import com.ecole221.prestation.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte findByClientId(long clientId);
}
