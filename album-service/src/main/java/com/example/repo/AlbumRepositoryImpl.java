package com.example.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.AlbumEntity;

import org.springframework.stereotype.Repository;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    private final EntityManager entityManager;
    
    private final Map<String, AlbumEntity> albums;

    {
        albums = new HashMap<>();
    }

    public AlbumRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public AlbumEntity findById(long id) {
        return entityManager.find(AlbumEntity.class, id);
    }

    @Override
    @Transactional
    public AlbumEntity save(AlbumEntity albumEntity) {
        if (albumEntity.getId() == 0) {
            entityManager.persist(albumEntity);
        } else {
            entityManager.merge(albumEntity);
        }
        return albumEntity;
    }

    @Override
    public List<AlbumEntity> findAll() {
    	Collection<AlbumEntity> collection = albums.values();
        return (List<AlbumEntity>) collection;
    }

    @Override
    @Transactional
    public void deleteAlbumById(AlbumEntity albumEntity) {
        entityManager.remove(albumEntity);
    }

}

