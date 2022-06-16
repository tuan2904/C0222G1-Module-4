package com.example.service;

import com.example.model.MedicalModel;

import java.util.List;

public interface IMedicalService {
    List<MedicalModel> listMedical(MedicalModel medicalModel);
}
