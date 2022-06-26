package com.example.furama.service.position;

import com.example.furama.model.Position;
import com.example.furama.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService{
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> listPosition() {
        return positionRepository.findAll();
    }
}
