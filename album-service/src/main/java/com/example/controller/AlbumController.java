package com.example.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.AlbumDto;
import com.example.exception.AlbumNotFoundException;
import com.example.model.AlbumEntity;
import com.example.service.AlbumService;
import com.example.ui.AlbumRequestModel;
import com.example.ui.AlbumResponseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final ModelMapper modelMapper;
    private final AlbumService albumService;

    public AlbumController(ModelMapper modelMapper, AlbumService albumService) {
		super();
		this.modelMapper = modelMapper;
		this.albumService = albumService;
	}

	@PostMapping
    public ResponseEntity<AlbumResponseModel> createAlbum(@RequestBody AlbumRequestModel albumRequestModel) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AlbumDto albumDto = modelMapper.map(albumRequestModel, AlbumDto.class);
		albumDto.setUserId(UUID.randomUUID().toString());
        AlbumEntity albumEntity = albumService.createAlbum(albumDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(albumEntity, AlbumResponseModel.class));
    }

    @GetMapping
    public ResponseEntity<List<AlbumResponseModel>> listAllAlbums() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<AlbumEntity> list = albumService.listAlbums();
        List<AlbumResponseModel> albumResponseModels = new ArrayList<>();
        for (AlbumEntity a : list) {
            albumResponseModels.add(modelMapper.map(a, AlbumResponseModel.class));
        }
        return ResponseEntity.status(HttpStatus.OK).body(albumResponseModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponseModel> getAlbumById(@PathVariable("id") long id)
            throws AlbumNotFoundException {
        AlbumEntity albumEntity = albumService.findById(id);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (albumEntity == null) {
            throw new AlbumNotFoundException("Album with id=" + id + " not found");
        } else {
            return ResponseEntity.ok(modelMapper.map(albumEntity, AlbumResponseModel.class));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponseModel> updateAlbum(@PathVariable("id") long id,
                                                          @RequestBody AlbumRequestModel albumRequestModel)
            throws AlbumNotFoundException {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AlbumDto albumDto = modelMapper.map(albumRequestModel, AlbumDto.class);
        AlbumEntity updatedAlbum = albumService.updateAlbumById(id, albumDto);
        if (updatedAlbum == null) {
            throw new AlbumNotFoundException("Album with id=" + id + " not found");
        }
        return ResponseEntity.ok(modelMapper.map(updatedAlbum, AlbumResponseModel.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable("id") long id) throws AlbumNotFoundException {
        albumService.deleteAlbumById(id);
        return ResponseEntity.noContent().build();
    }
}
