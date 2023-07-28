package com.example.service;

import java.util.List;

import com.example.dto.AlbumDto;
import com.example.model.AlbumEntity;

public interface AlbumService {
	
	AlbumEntity createAlbum(AlbumDto albumDto);
	List<AlbumEntity> listAlbums();
	AlbumEntity findById(long id);
	AlbumEntity updateAlbumById(long id, AlbumDto albumDto);
	void deleteAlbumById(long id);

}
