package com.example.mongodbapi;

import com.example.mongodbapi.model.Address;
import com.example.mongodbapi.model.Gender;
import com.example.mongodbapi.model.Student;
import com.example.mongodbapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class MongoDbApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApiApplication.class, args);
    }

}
