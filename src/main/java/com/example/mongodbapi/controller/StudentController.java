package com.example.mongodbapi.controller;

import com.example.mongodbapi.model.Student;
import com.example.mongodbapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return service.getAllStudents();
    }
}
