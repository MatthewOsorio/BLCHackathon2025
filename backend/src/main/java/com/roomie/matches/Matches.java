package com.roomie.matches;

import com.roomie.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Matches {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private Integer score;
    
    @ManyToOne
    @JoinColumn(name= "primary_student_id")
    private Student primaryStudent;

    @ManyToOne
    @JoinColumn(name= "secondary_student_id")
    private Student secondaryStudent;

    public Matches() {}

    public Matches(Student primaryStudent, Student secondaryStudent, int score) {
        this.primaryStudent = primaryStudent;
        this.secondaryStudent = secondaryStudent;
    }

    public Matches(Long id, Student primaryStudent, Student secondaryStudent, int score) {
        this.id = id;
        this.primaryStudent = primaryStudent;
        this.secondaryStudent = secondaryStudent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getPrimaryStudent() {
        return primaryStudent;
    }

    public void setPrimaryStudent(Student primaryStudent) {
        this.primaryStudent = primaryStudent;
    }

    public Student getSecondaryStudent() {
        return secondaryStudent;
    }

    public void setSecondaryStudent(Student secondaryStudent) {
        this.secondaryStudent = secondaryStudent;
    }

    public Integer getScore(){
        return score;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    @Override
    public String toString() {
        return "Matches{" +
                "id=" + id +
                ", primaryStudent=" + primaryStudent.getId() +
                ", secondaryStudent=" + secondaryStudent.getId() +
                ", score=" + score +
                '}';
    }
}
