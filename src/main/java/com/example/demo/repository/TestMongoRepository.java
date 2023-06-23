package com.example.demo.repository;

import com.example.demo.model.TestMongoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMongoRepository extends MongoRepository<TestMongoDocument, String> {



}
