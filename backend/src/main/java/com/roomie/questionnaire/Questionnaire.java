package com.roomie.questionnaire;

import com.roomie.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String responseOne;
    private String responseTwo;
    private String responseThree;
    private String responseFour;
    private String responseFive;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public Questionnaire(){}

    public Questionnaire(Long id, String responseOne, String responseTwo, String responseThree, String responseFour, String responseFive){
        this.id = id;
        this.responseOne = responseOne;
        this.responseTwo = responseTwo;
        this.responseThree = responseThree;
        this.responseFour = responseFour;
        this.responseFive = responseFive;
    }

    public Questionnaire(String responseOne, String responseTwo, String responseThree, String responseFour, String responseFive){
        this.responseOne = responseOne;
        this.responseTwo = responseTwo;
        this.responseThree = responseThree;
        this.responseFour = responseFour;
        this.responseFive = responseFive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponseOne() {
        return responseOne;
    }

    public void setResponseOne(String responseOne) {
        this.responseOne = responseOne;
    }

    public String getResponseTwo() {
        return responseTwo;
    }

    public void setResponseTwo(String responseTwo) {
        this.responseTwo = responseTwo;
    }

    public String getResponseThree() {
        return responseThree;
    }

    public void setResponseThree(String responseThree) {
        this.responseThree = responseThree;
    }

    public String getResponseFour() {
        return responseFour;
    }

    public void setResponseFour(String responseFour) {
        this.responseFour = responseFour;
    }

    public String getResponseFive() {
        return responseFive;
    }

    public void setResponseFive(String responseFive) {
        this.responseFive = responseFive;
    }

    public Student getStudent(){
        return student;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", responseOne='" + responseOne + '\'' +
                ", responseTwo='" + responseTwo + '\'' +
                ", responseThree='" + responseThree + '\'' +
                ", responseFour='" + responseFour + '\'' +
                ", responseFive='" + responseFive + '\'' +
                '}';
    }
}
