package com.example.service;

import com.example.model.MusicModel;
import com.example.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository repository;
    @Override
    public List<MusicModel> listMusic() {
        return repository.listMusic();
    }

    @Override
    public void save(MusicModel musicModel) {
        repository.save(musicModel);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public void update(MusicModel musicModel) {
    repository.update(musicModel);
    }

    @Override
    public MusicModel searchId(int id) {

        return repository.searchId(id);
    }
}
