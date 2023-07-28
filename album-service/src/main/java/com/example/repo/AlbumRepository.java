package com.example.repo;

import java.util.List;

import com.example.model.AlbumEntity;

public interface AlbumRepository {
    AlbumEntity findById(long id);
    AlbumEntity save(AlbumEntity albumEntity);
    List<AlbumEntity> findAll();
	void deleteAlbumById(AlbumEntity albumEntity);
}
