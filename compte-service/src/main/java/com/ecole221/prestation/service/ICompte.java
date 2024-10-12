package com.ecole221.prestation.service;


import com.ecole221.prestation.model.Compte;

public interface ICompte {
    Compte save(Compte compte);
    Compte findByClientId(long clientId);
}
