package com.example.music.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "music_table")
public class MusicModel implements Validator {
    @Id
    @Column(name = "id_music", columnDefinition = "INT")
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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicModel music = (MusicModel) target;
        if (!music.nameMusic.matches("^[a-zA-Z0-9]{1,800}$")) {
            errors.rejectValue("nameMusic", "nameMusic.invalidFormat");
        }
        if (!music.performanceArtist.matches("^[\\\\w]{1,300}$")) {
            errors.rejectValue("performanceArtist", "performanceArtist.invalidFormat");
        }
        if (!music.performanceArtist.matches("^[\\\\w,]{1,1000}$")) {
            errors.rejectValue("musicGenre", "musicGenre.invalidFormat");
        }
    }
}
