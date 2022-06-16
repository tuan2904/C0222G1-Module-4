package com.example.service;

import com.example.model.MedicalModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Override
    public List<MedicalModel> listMedical(MedicalModel medicalModel) {
        List<MedicalModel> medicalModels = new ArrayList<>();
        medicalModels.add(medicalModel);
        return medicalModels;
    }
}
