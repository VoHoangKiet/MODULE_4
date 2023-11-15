package org.example.repository.impl;

import org.example.entity.Song;
import org.example.repository.SongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class SongRepositoryImpl implements SongRepository {
    public SongRepositoryImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean create(Song song) {
        entityManager.persist(song);
        return true;
    }

    @Override
    public boolean update(Song song) {
        entityManager.merge(song);
        return true;
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("From Song ").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }
}
