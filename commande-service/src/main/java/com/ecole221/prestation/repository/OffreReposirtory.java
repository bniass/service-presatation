package com.ecole221.prestation.repository;

import com.ecole221.prestation.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreReposirtory extends JpaRepository<Offre, Long> {
}
