package com.example.mongodbapi.service;

import com.example.mongodbapi.model.Student;
import com.example.mongodbapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

}
