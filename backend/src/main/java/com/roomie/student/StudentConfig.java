package com.roomie.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student matt = new Student(
                "Matt",
                LocalDate.of(2002, Month.DECEMBER, 21),
                "mattosoriox@gmail.com",
                "password",
                "unr"
            );


            repository.saveAll(List.of(matt));
        };
    };
}

