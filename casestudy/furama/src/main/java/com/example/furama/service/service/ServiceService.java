package com.example.furama.service.service;

import com.example.furama.model.Service;
import com.example.furama.repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Service> listService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> list() {
        return serviceRepository.findAll();
    }

    @Override
    public void remove(int id) {
        serviceRepository.delete(id);
    }

    @Override
    public void update(Service service) {
        serviceRepository.editService(service.getServiceName(), service.getServiceArea(), service.getServiceCost(), service.getServiceMaxPeople(),
                service.getRentType().getIdRentType(), service.getServiceType().getIdServiceType(), service.getServiceRoom(), service.getServiceDescription()
                , service.getServicePoolArea(), service.getServiceNumberFloors(), service.getServiceId());
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findId(id);
    }

    @Override
    public void create(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Page<Service> search(Service service, Pageable pageable) {
        return serviceRepository.search(service.getServiceName(), pageable);
    }
}
