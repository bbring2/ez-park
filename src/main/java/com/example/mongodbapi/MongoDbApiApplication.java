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

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            String email = "bbring@bbringworld.com";
            Address address = new Address("Bbringworld", "Seoul", "00000");
            Student student = new Student("Bbring", "world",
                    email, Gender.FEMALE, address, List.of("" +
                    "Computer Science", "Physics"),
                    BigDecimal.TEN);

//            usingMongoTemplateAndQuery(email, student, studentRepository, mongoTemplate);

            studentRepository.findStudentByEmail(email)
                    .ifPresentOrElse(s -> {
                        System.out.println(s + "already exists.");
                    }, () -> {
                            System.out.println("Added student");
                            studentRepository.insert(student);
                    });
        };
    }

    private void usingMongoTemplateAndQuery(String email, Student student, StudentRepository repository, MongoTemplate template) {
        Query query = new Query();
        query.addCriteria(Criteria.where(email).is(email));


        List<Student> students = template.find(query, Student.class);

        if(students.size() > 1) {
            throw new IllegalArgumentException("There are too many students who has this email : " + email);
        }

        if(students.isEmpty()) {
            System.out.println("Added student");
            repository.insert(student);
        } else {
            System.out.println(student + "already exists.");
        }
    }
}
