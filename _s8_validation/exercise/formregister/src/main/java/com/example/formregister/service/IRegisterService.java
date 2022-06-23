package com.example.formregister.service;

import com.example.formregister.model.Register;

import java.util.List;

public interface IRegisterService {
    List<Register> listRegister();
    void save(Register musicModel);
}
