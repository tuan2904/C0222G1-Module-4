package com.example.furama.service.servicetype;

import com.example.furama.model.ServiceType;
import com.example.furama.repository.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeService implements IServiceTypeService{
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> listServiceType() {
        return serviceTypeRepository.findAll();
    }
}
