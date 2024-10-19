package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Service;
import com.ecole221.prestation.repository.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements IService{
    private final ServiceRepository serviceRepository;

    public ServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service find(long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
