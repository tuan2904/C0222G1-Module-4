package com.example.music.service;


import com.example.music.model.MusicModel;

import java.util.List;

public interface IMusicService {
    List<MusicModel> listMusic();

     void save(MusicModel musicModel);

    void remove(int id);
    void update(MusicModel musicModel);

    MusicModel searchId(int id);
}
