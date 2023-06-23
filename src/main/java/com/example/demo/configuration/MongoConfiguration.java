package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration {

    private final MongoDatabaseFactory mongoDatabaseFactory;

    public MongoConfiguration(MongoDatabaseFactory mongoDatabaseFactory) {
        this.mongoDatabaseFactory = mongoDatabaseFactory;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDatabaseFactory);
    }
}

