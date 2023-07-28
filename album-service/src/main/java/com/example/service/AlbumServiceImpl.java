package com.example.service;

import javax.transaction.Transactional;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.dto.AlbumDto;
import com.example.model.AlbumEntity;
import com.example.repo.AlbumRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public AlbumEntity createAlbum(AlbumDto albumDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        AlbumEntity albumEntity = modelMapper.map(albumDto, AlbumEntity.class);
        return albumRepository.save(albumEntity);
    }

    @Override
    public List<AlbumEntity> listAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public AlbumEntity findById(long id) {
        return albumRepository.findById(id);
    }

    @Override
    @Transactional
    public AlbumEntity updateAlbumById(long id, AlbumDto albumDto) {
        AlbumEntity albumEntity = albumRepository.findById(id);
        if (albumEntity == null) {
            return null;
        }
        albumEntity.setAlbumId(albumDto.getAlbumId());
        albumEntity.setUserId(albumDto.getUserId());
        albumEntity.setName(albumDto.getName());
        albumEntity.setDescription(albumDto.getDescription());
        return albumRepository.save(albumEntity);
    }

    @Override
    @Transactional
    public void deleteAlbumById(long id) {
        AlbumEntity albumEntity = albumRepository.findById(id);
        if (albumEntity != null) {
            albumRepository.deleteAlbumById(albumEntity);
        }
    }
}
