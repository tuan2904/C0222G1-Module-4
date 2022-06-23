package com.example.formregister.service;

import com.example.formregister.model.Register;
import com.example.formregister.repository.IRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterService implements IRegisterService{
@Autowired
private IRegisterRepository registerRepository;
    @Override
    public List<Register> listRegister() {
        return registerRepository.listMusic();
    }

    @Override
    public void save(Register register) {
        registerRepository.save(register);
    }

}
