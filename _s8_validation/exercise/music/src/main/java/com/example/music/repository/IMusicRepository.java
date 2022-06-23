package com.example.music.repository;


import com.example.music.model.MusicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IMusicRepository extends JpaRepository<MusicModel, Integer> {
    @Query(value = "select * from music_table", nativeQuery = true)
    List<MusicModel> listMusic();

    @Query(value = "select * from music_table where id_music=:id_music", nativeQuery = true)
    MusicModel findAllByIdMusic(@Param("id_music") int id);

    @Modifying
    @Query(value = "update music_table set id_music=:id_music, name_music=:name_music,performance_artist=:performance_artist,music_genre=:music_genre,file_path=:file_path where id_music=:id_music",
            nativeQuery = true)
    void editMusic(@Param("id_music") int id, @Param("name_music") String name,
                   @Param("performance_artist") String price, @Param("music_genre") String describe,
                   @Param("file_path") String producer);
}
