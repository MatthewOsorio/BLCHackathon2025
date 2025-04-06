package com.roomie.student;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.roomie.matches.Matches;
import com.roomie.questionnaire.Questionnaire;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;
    private String email;
    private String password;
    private String university;
    private List<String> tags;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy = "primaryStudent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Matches> matches;
    
    public Student(){}

    public Student(Long id, String name, LocalDate dob, String email, String password, String university, List<String> tags){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.university = university;
        this.tags = tags;
    }

    public Student(String name, LocalDate dob, String email, String password, String university, List<String> tags){
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.university = university;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }   

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Questionnaire getQuestionnaire(){
        return questionnaire;
    }

    public void setQuestionare(Questionnaire questionnaire){
        this.questionnaire = questionnaire;
    }

    public List<String> getTags(){
        return tags;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + getAge() +
                ", email='" + email + '\'' +
                ", university='" + university + '\'' +
                ", tags=" + tags +
                '}';
    }
}