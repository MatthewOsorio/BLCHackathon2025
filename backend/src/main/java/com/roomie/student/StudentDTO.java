package com.roomie.student;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
    private Long id;
    private String name;
    private LocalDate dob;
    private Integer age;
    private String email;
    private String university;
    private List<String> tags;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.dob = student.getDob();
        this.age = student.getAge();
        this.email = student.getEmail();
        this.university = student.getUniversity();
        this.tags = student.getTags();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge(){
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getUniversity() {
        return university;
    }

    public List<String> getTags() {
        return tags;
    }

}
