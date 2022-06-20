package com.example.repository;

import com.example.model.MusicModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class MusicRepository implements IMusicRepository {
    @Override
    public List<MusicModel> listMusic() {
        List<MusicModel> listMusic = BaseRepository.entityManager.createQuery("select m from music_i m", MusicModel.class).getResultList();
        return listMusic;
    }

    @Override
    public void save(MusicModel musicModel) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(musicModel);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        MusicModel musicModel = searchId(id);
        BaseRepository.entityManager.remove(musicModel);
        entityTransaction.commit();
    }

    @Override
    public void update(MusicModel musicModel) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(musicModel);
        entityTransaction.commit();
    }

    @Override
    public MusicModel searchId(int id) {
        MusicModel listMusic = (MusicModel) BaseRepository.entityManager.createQuery("select p from music_i p where p.idMusic=?1").setParameter(1, id).getSingleResult();
        return listMusic;
    }
}

