package com.example.music.service;

import com.example.music.model.MusicModel;
import com.example.music.repository.IMusicRepository;
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

    }

    @Override
    public void update(MusicModel musicModel) {
    repository.editMusic(musicModel.getIdMusic(),musicModel.getNameMusic(),musicModel.getPerformanceArtist()
    ,musicModel.getMusicGenre(),musicModel.getFilePath());
    }

    @Override
    public MusicModel searchId(int id) {

        return repository.findAllByIdMusic(id);
    }
}
