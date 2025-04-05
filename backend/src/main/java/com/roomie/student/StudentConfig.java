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
                "matt@gmail.com",
                "password",
                "unr",
                List.of("sports", "outdoors", "movies")
            );

            Student john = new Student(
                "john",
                LocalDate.of(1999, Month.DECEMBER, 12),
                "john@gmail.com",
                "password",
                "unr",
                List.of("gaming", "late-night", "music")
                
            );

            Student vanessa = new Student(
                "vanessa",
                LocalDate.of(2003, Month.JUNE, 1),
                "mattosoriox@gmail.com",
                "password",
                "unr",
                List.of("clean", "early bird", "coffee")
            );

            Student bousso = new Student(
                "bousso",
                LocalDate.of(2000, Month.FEBRUARY, 15),
                "bousso@gmail.com",
                "password",
                "unr",
                List.of("pets", "fashion", "reading")
            );

            Student chad = new Student(
                "chad",
                LocalDate.of(1995, Month.MARCH, 3),
                "chad@gmail.com",
                "password",
                "ucla",
                List.of("gym", "early bird", "clean")
            );

            Student leslie = new Student(
                "leslie",
                LocalDate.of(2003, Month.JUNE, 11),
                "leslie@gmail.com",
                "password",
                "unr",
                List.of("quiet", "studious", "vegan")
            );

            Student linsey = new Student(
                "linsey",
                LocalDate.of(2003, Month.JUNE, 11),
                "linsey@gmail.com",
                "password",
                "unr",
                List.of("outdoors", "music", "pets")
                );

            Student ty = new Student(
                "ty",
                LocalDate.of(2002, Month.AUGUST, 12),
                "ty@gmail.com",
                "password",
                "unr",
                List.of("night owl", "gaming", "foodie")

            );

            repository.saveAll(List.of(matt, john, vanessa, bousso, chad, leslie, linsey, ty));
        };
    };
}

