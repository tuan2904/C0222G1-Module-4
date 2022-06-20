package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "music_i")
public class MusicModel {
    @Id
    @Column(name = "id_music",columnDefinition = "INT")
    private int idMusic;
    @Column(name = "name_music", columnDefinition = "VARCHAR(200)")
    private String nameMusic;
    @Column(name = "performance_artist", columnDefinition = "VARCHAR(200)")
    private String performanceArtist;
    @Column(name = "music_genre", columnDefinition = "VARCHAR(200)")
    private String musicGenre;
    @Column(name = "file_path", columnDefinition = "VARCHAR(200)")
    private String filePath;

    public MusicModel() {
    }

    public int getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getPerformanceArtist() {
        return performanceArtist;
    }

    public void setPerformanceArtist(String performanceArtist) {
        this.performanceArtist = performanceArtist;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
