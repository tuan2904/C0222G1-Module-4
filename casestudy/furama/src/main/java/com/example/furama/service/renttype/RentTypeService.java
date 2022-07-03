package com.example.furama.service.renttype;

import com.example.furama.model.RentType;
import com.example.furama.repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> listRent() {
        return rentTypeRepository.findAll();
    }
}
