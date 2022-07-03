package com.example.furama.service.educationdegree;

import com.example.furama.model.EducationDegree;
import com.example.furama.repository.IEducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> listEducation() {
        return educationDegreeRepository.findAll();
    }
}
