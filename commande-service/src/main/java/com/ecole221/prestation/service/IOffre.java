package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Offre;

import java.util.List;

public interface IOffre {
    Offre save(Offre service);
    Offre find(long id);
    List<Offre> findAll();
}