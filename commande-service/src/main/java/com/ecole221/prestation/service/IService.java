package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Service;

import java.util.List;

public interface IService {
    Service save(Service service);
    Service find(long id);
    List<Service> findAll();
}