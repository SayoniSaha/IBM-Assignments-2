package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Stream;

public interface StreamRepository extends MongoRepository<Stream, String>{

}
