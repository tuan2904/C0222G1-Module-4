package com.example.furama.service.user;

import com.example.furama.model.User;
import com.example.furama.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
