package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/mongo")
    public TestMongoDocument createDocument(@RequestBody TestMongoDTO testMongoDTO) {
        return testService.create(testMongoDTO);
    }

    @PutMapping("/mongo/{id}")
    public TestMongoDocument updateDocument(@RequestBody TestMongoDTO testMongoDTO, @PathVariable String id) {
        return testService.update(testMongoDTO, id);
    }

    @DeleteMapping("/mongo/{id}")
    public void delete(@PathVariable String id) {
        testService.delete(id);
    }

    @GetMapping("/mongo/{id}")
    public TestMongoDocument find(@PathVariable String id) {
        return testService.find(id);
    }
}

