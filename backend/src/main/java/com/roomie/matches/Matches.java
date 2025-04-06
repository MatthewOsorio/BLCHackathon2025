package com.roomie.matches;

import com.roomie.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"primary_student_id", "secondary_student_id"})
    }
)
public class Matches {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private boolean primaryLiked = false;
    private boolean secondaryLiked = false;

    @ManyToOne
    @JoinColumn(name= "primary_student_id")
    private Student primaryStudent;

    @ManyToOne
    @JoinColumn(name= "secondary_student_id")
    private Student secondaryStudent;

    public Matches() {}

    public Matches(Student primaryStudent, Student secondaryStudent) {
        this.primaryStudent = primaryStudent;
        this.secondaryStudent = secondaryStudent;
    }

    public Matches(Long id, Student primaryStudent, Student secondaryStudent) {
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

    public boolean getPrimaryLiked(){
        return primaryLiked;
    }

    public void setPrimaryLiked(boolean primaryLiked){
        this.primaryLiked = primaryLiked;
    }

    public boolean getSecondaryLiked(){
        return secondaryLiked;
    }

    public void setSecondaryLiked(boolean secondaryLiked){
        this.secondaryLiked = secondaryLiked;
    }

    public boolean isMutual(){
        return primaryLiked && secondaryLiked;
    }

    @Override
    public String toString() {
        return "Matches{" +
                "id=" + id +
                ", primaryStudent=" + primaryStudent.getId() +
                ", secondaryStudent=" + secondaryStudent.getId() +
                '}';
    }
}
