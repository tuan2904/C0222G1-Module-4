package com.example.service;

import com.example.model.MusicModel;

import java.util.List;

public interface IMusicService {
    List<MusicModel> listMusic();

     void save(MusicModel musicModel);

    void remove(int id);
    void update(MusicModel musicModel);

    MusicModel searchId(int id);
}
