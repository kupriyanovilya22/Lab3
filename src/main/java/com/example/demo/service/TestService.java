package com.example.demo.service;

import com.example.demo.model.TestMongoDTO;
import com.example.demo.model.TestMongoDocument;
import com.example.demo.repository.TestMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestMongoRepository testMongoRepository;

    @Autowired
    public TestService(TestMongoRepository testMongoRepository) {
        this.testMongoRepository = testMongoRepository;
    }

    public TestMongoDocument create(TestMongoDTO testMongoDTO) {
        TestMongoDocument testMongoDocument = new TestMongoDocument();
        testMongoDocument.setFirstName(testMongoDTO.getFirstName());
        testMongoDocument.setLastName(testMongoDTO.getLastName());
        testMongoDocument.setFaculty(testMongoDTO.getFaculty());
        testMongoDocument.setMark(testMongoDTO.getMark());
        return testMongoRepository.save(testMongoDocument);
    }

    public TestMongoDocument update(TestMongoDTO testMongoDTO, String operationID) {
        return testMongoRepository.findById(operationID).map(existingDocument -> {
            existingDocument.setFirstName(testMongoDTO.getFirstName());
            existingDocument.setLastName(testMongoDTO.getLastName());
            existingDocument.setFaculty(testMongoDTO.getFaculty());
            existingDocument.setMark(testMongoDTO.getMark());
            return testMongoRepository.save(existingDocument);
        }).orElse(null);
    }

    public void delete(String operationID) {
        testMongoRepository.deleteById(operationID);
    }

    public TestMongoDocument find(String operationID) {
        return testMongoRepository.findById(operationID).orElse(null);
    }
}

