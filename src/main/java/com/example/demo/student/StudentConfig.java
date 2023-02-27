package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student tom = new Student(
                    "Tom",
                    LocalDate.of(2000, 1, 1),
                    "Tom@gmail.com"
            );
            Student alex = new Student(
                    "alex",
                    LocalDate.of(2001, 1, 1),
                    "Alex@gmail.com"
            );
            repository.saveAll( //Save data to database
                    List.of(tom, alex)
            );
        };
    }
}
