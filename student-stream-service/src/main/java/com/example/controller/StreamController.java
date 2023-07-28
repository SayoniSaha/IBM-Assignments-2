package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Stream;
import com.example.service.StreamService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/streams")
@AllArgsConstructor
public class StreamController {

	private final StreamService streamService;
	
	@PostMapping
	public ResponseEntity<Stream> createStream(@RequestBody Stream stream) {
		return ResponseEntity.status(HttpStatus.CREATED).body(streamService.createStream(stream));
	}
}
