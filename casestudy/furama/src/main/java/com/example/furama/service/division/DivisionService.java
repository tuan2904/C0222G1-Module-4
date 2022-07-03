package com.example.furama.service.division;

import com.example.furama.model.Division;
import com.example.furama.repository.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> listDivision() {
        return divisionRepository.findAll();
    }
}
