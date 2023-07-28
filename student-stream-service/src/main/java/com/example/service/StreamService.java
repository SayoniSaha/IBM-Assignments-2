package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Stream;

public interface StreamService {
	Stream createStream(Stream stream);
	Optional<Stream> findStream(String id);
	List<Stream> getAllStream();

}
