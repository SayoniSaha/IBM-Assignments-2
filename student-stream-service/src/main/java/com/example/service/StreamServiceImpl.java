package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Stream;
import com.example.repo.StreamRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StreamServiceImpl implements StreamService {

	private final StreamRepository streamRepository;

	@Override
	public Stream createStream(Stream stream) {
		return streamRepository.save(stream);
	}

	@Override
	public Optional<Stream> findStream(String id) {
		return streamRepository.findById(id);
	}

	@Override
	public List<Stream> getAllStream() {
		return null;
	}

}
